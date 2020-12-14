/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

/**
 *
 * @author crist
 */
public class Movement {

    int from_row = 0;
    int from_col = 0;
    int to_row = 0;
    int to_col = 0;
    int value = 0;

    public int getFrom_row() {
        return from_row;
    }

    public void setFrom_row(int from_row) {
        this.from_row = from_row;
    }

    public int getFrom_col() {
        return from_col;
    }

    public void setFrom_col(int from_col) {
        this.from_col = from_col;
    }

    public int getTo_row() {
        return to_row;
    }

    public void setTo_row(int to_row) {
        this.to_row = to_row;
    }

    public int getTo_col() {
        return to_col;
    }

    public void setTo_col(int to_col) {
        this.to_col = to_col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(String fromBoardSquares, String toBoardSquares) {
        if(toBoardSquares.equals(" ")){
            this.value = loadValuePieces(fromBoardSquares);
        }else{
            this.value = loadValuePieces(toBoardSquares) * 10;
        }
    }

    private int loadValuePieces(String pieces) {
        if (null != pieces) {
            switch (pieces) {
                case "p":
                    return 10;

                case "P":
                    return 10;
                    
                case "h":
                    return 30;

                case "H":
                    return 30;
                
                case "b":
                    return 40;
                
                case "B":
                    return 40;
                
                case "r":
                    return 60;
                   
                case "R":
                    return 60;
                    
                case "q":
                    return 5;
                
                case "Q":
                    return 5;
                    
                case "k":
                    return 100;
                
                case "K":
                    return 100;
                    
                default:
                    return 0;
            }
        }
        return 0;
    }
}
