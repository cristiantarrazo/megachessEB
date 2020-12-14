package conection;

import java.net.URI;
import java.util.Map;
import javax.swing.JOptionPane;
import logic.GameLogic;
import transfer.Movement;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

public class ClientWS extends WebSocketClient {

    private GameLogic gameMove;
    private Movement movement;
    private static int numbreOfChallenge = 0;
    
    public ClientWS(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public ClientWS(URI serverURI) {
        super(serverURI);
    }

    public ClientWS(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("[onOpen Running]");
        JSONObject action = new JSONObject();
        action.put("action", "login");
        action.put("data", "{}");
        send(JSONObject.valueToString(action));
        System.out.println("[Login...]");
    }

    @Override
    public void onMessage(String message) {
        JSONObject event = new JSONObject(message);
        JSONObject dataEvent;
        JSONObject action;
        JSONObject dataAction;
        
        String eventString = event.get("event").toString();
        dataEvent = event.getJSONObject("data");
        
        if (null != eventString) switch (eventString) {
            
            //Challenge
            case "update_user_list":
                if(numbreOfChallenge == 0){
                    String userToChallenge = "";
                    System.out.println("[Challenge...]");
                    action = new JSONObject();
                    dataAction = new JSONObject();      
                    System.out.println("Users Conected: " + dataEvent.getJSONArray("users_list"));
                    numbreOfChallenge = numbreOfChallenge + 1;
                    try{
                        userToChallenge = JOptionPane.showInputDialog(null, "Text de name of User", "User to Challenge");
                    }catch(Exception e){}
                    if(userToChallenge != null){
                        if(!userToChallenge.isEmpty()){
                            System.out.println("[Send Challenge...]");
                            action.put("action", "challenge");
                            dataAction.put("username", userToChallenge);
                            dataAction.put("message", "Do you want to play?");
                            action.put("data", dataAction);
                            send(JSONObject.valueToString(action));
                        }else{
                            numbreOfChallenge = numbreOfChallenge - 1;
                        }
                    }
                }
                break;
            
            //Ask Challenge
            case "ask_challenge":
                System.out.println("[Username Ask Challenge:] " + dataEvent.getString("username"));
                int respuesta = -1;
                try{
                    respuesta = JOptionPane.showConfirmDialog(null, "Do you want to play with " + dataEvent.getString("username"), "Ask Challenge", JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception e){}
                if(respuesta == 0){
                    action = new JSONObject();
                    dataAction = new JSONObject();
                    action.put("action", "accept_challenge");
                    dataAction.put("board_id", dataEvent.getString("board_id"));
                    action.put("data", dataAction);
                    send(JSONObject.valueToString(action));
                    System.out.println("[Accept Challenge...]");
                }
                break;
               
            //Move
            case "your_turn":
                if(numbreOfChallenge == 0){
                    numbreOfChallenge = numbreOfChallenge + 1;
                }
                action = new JSONObject();
                dataAction = new JSONObject();
                gameMove = new GameLogic();
                movement = new Movement();
                
                movement = gameMove.moveStrategy(dataEvent.getString("actual_turn"), dataEvent.getString("board"), String.valueOf(dataEvent.get("move_left")), String.valueOf(dataEvent.get("username")));
                
                if(movement != null){
                    action.put("action", "move");
                    dataAction.put("board_id", dataEvent.getString("board_id"));
                    dataAction.put("turn_token", dataEvent.getString("turn_token"));
                    dataAction.put("from_row", movement.getFrom_row());
                    dataAction.put("from_col", movement.getFrom_col());
                    dataAction.put("to_row", movement.getTo_row());
                    dataAction.put("to_col", movement.getTo_col());
                    action.put("data", dataAction);
                    send(JSONObject.valueToString(action));
                }else{
                    System.out.println("------------------------------------------------");
                    System.out.println("En ClientWS - Movement == null... Error!!!");
                    action.put("action", "abort");
                    dataAction.put("board_id", dataEvent.getString("board_id"));
                    action.put("data", dataAction);
                    send(JSONObject.valueToString(action));
                }
                break;


                
            //Move
            case "gameover":
                numbreOfChallenge = numbreOfChallenge - 1;
                System.out.println("[Game Over...]");
                String whiteScore = dataEvent.getString("white_score");
                String blackScore = dataEvent.getString("black_score");
                if(Integer.parseInt(whiteScore) < Integer.parseInt(blackScore)){
                    System.out.println("Winner " + dataEvent.getString("black_username") + "!!!");
                    System.out.println("Black Score: " + dataEvent.getString("black_score"));
                     System.out.println("White Player: " + dataEvent.getString("white_username") + "!!!");
                    System.out.println("White Score: " + dataEvent.getString("white_score"));
                }else{
                    System.out.println("Winner " + dataEvent.getString("white_username") + "!!!");
                    System.out.println("White Score: " + dataEvent.getString("white_score"));
                    System.out.println("Black Player: " + dataEvent.getString("black_username") + "!!!");
                    System.out.println("Black Score: " + dataEvent.getString("black_score"));
                }
                if(Integer.parseInt(whiteScore) == Integer.parseInt(blackScore)){
                    System.out.println("Tied!!!");
                    System.out.println("White Score: " + dataEvent.getString("white_score"));
                    System.out.println("Black Score: " + dataEvent.getString("black_score"));
                }
                action = new JSONObject();
                action.put("action", "get_connected_users");
                action.put("data", "{}");
                send(JSONObject.valueToString(action));
                break;
                
            default:
                break;
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println(
                "Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
                + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
