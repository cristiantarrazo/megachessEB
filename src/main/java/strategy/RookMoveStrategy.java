package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.Rook;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class RookMoveStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listRook;

        if (color.equals("black")) { //Black
            listRook = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("r")) {
                    listRook.add(i);
                }
            }
            
            int whitePices = 0;
            for (int i = 0; i < 127; i++) {
                if(Character.isUpperCase(i)){
                    whitePices += 1;
                }
            }
            
            int stepLimit = 15;
            if(whitePices != 0){
                stepLimit = 7;
            }

            if (listRook.isEmpty() == false) {
                for (int j = 0; j < listRook.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean lineUp = true;
                    boolean lineDown = true;
                    boolean lineRight = true;
                    boolean lineLeft = true;

                    for (int i = 1; i <= 15; i++) {
                        //Line Up
                        if (from_row + i <= stepLimit) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                lineUp = false;
                            }
                            if (lineUp == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row + i, from_col, color, 58);
                                }
                            }
                        }
                        //Line Down
                        if (from_row - i >= 0) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                                lineDown = false;
                            }
                            if (lineDown == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row - i, from_col, color, 69);
                                }
                            }
                        }
                        //Line Right
                        if (from_col + i <= 15) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                lineRight = false;
                            }
                            if (lineRight == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col + i, color, 80);
                                }
                            }
                        }
                        //Line Left
                        if (from_col - i >= 0) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                                lineLeft = false;
                            }
                            if (lineLeft == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col - i, color, 91);
                                }
                            }
                        }
                    }
                }
            }
        } else { //White
            listRook = new ArrayList();
            for (int i = 255; i >= 0; i--) {
                if (String.valueOf(board.charAt(i)).equals("R")) {
                    listRook.add(i);
                }
            }

            int blackPices = 0;
            for (int i = 128; i < 255; i++) {
                if(Character.isLowerCase(i)){
                    blackPices += 1;
                }
            }
            
            int stepLimit = 0;
            if(blackPices != 0){
                stepLimit = 8;
            }
            
            if (listRook.isEmpty() == false) {
                for (int j = 0; j < listRook.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean lineUp = true;
                    boolean lineDown = true;
                    boolean lineRight = true;
                    boolean lineLeft = true;

                    for (int i = 1; i <= 15; i++) {
                        //Line Up
                        if (from_row + i <= 15) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                lineUp = false;
                            }
                            if (lineUp == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row + i, from_col, color, 137);
                                }
                            }
                        }
                        //Line Down
                        if (from_row - i >= stepLimit) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                                lineDown = false;
                            }
                            if (lineDown == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row - i, from_col, color, 148);
                                }
                            }
                        }
                        //Line Right
                        if (from_col + i <= 15) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                lineRight = false;
                            }
                            if (lineRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col + i, color, 159);
                                }
                            }
                        }
                        //Line Left
                        if (from_col - i >= 0) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                                lineLeft = false;
                            }
                            if (lineLeft == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                                    return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col - i, color, 170);
                                }
                            }
                        }
                    }
                }
            }
        }
        movementDTO.setApply(false);
        return movementDTO;
    }

    private int calculateRow(int index) {
        return index / 16;
    }

    private int calculateCol(int index, int row) {
        return index - (row * 16);
    }

    private int calculateIndex(int row, int col) {
        return ((row * 16) + col);
    }
}
