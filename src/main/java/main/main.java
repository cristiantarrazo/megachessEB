package main;
import conection.ClientWS;

import java.net.URISyntaxException;
import java.net.URI;

public class main {

    private static String stringQAURI = "ws://mega-chess-qa.herokuapp.com/service?authtoken=b8546a0e-9eba-40dd-b2b1-d051c2406e49";
    private static String stringURI = "ws://megachess.herokuapp.com/service?authtoken=dcb12b99-b0cd-4aa2-aaa1-1509b9401095";
    
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("[Main Running...]");
        ClientWS c = new ClientWS(new URI(stringURI));
        c.connect();
    }

}
