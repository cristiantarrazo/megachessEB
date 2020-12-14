package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.King;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class KingMoveStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listKing;

        if (color.equals("black")) { //Black
            listKing = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("k")) {
                    listKing.add(i);
                }
            }

            if (listKing.isEmpty() == false) {
                for (int i = 0; i < listKing.size(); i++) {
                    int index = Integer.valueOf(String.valueOf(listKing.get(i)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    //Line Up
                    if (from_row + 1 <= 15) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col, color, 37);
                            }
                        }
                    }
                    //Line Down
                    if (from_row - 1 >= 0) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col, color, 45);
                            }
                        }
                    }
                    //Line Right
                    if (from_col + 1 <= 15) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row, from_col + 1, color, 53);
                            }
                        }
                    }
                    //Line Left
                    if (from_col - 1 >= 0) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row, from_col - 1, color, 61);
                            }
                        }
                    }
                    //Diagonal Up and Right
                    if ((from_row + 1 <= 15) && (from_col + 1 <= 15)) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col + 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col + 1, color, 69);
                            }
                        }
                    }
                    //Diagonal Up and Left
                    if ((from_row + 1 <= 15) && (from_col - 1 >= 0)) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col - 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col - 1, color, 77);
                            }
                        }
                    }
                    //Diagonal Down and Right
                    if ((from_row - 1 >= 0) && (from_col + 1 <= 15)) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col + 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col + 1, color, 85);
                            }
                        }
                    }
                    //Diagonal Down and Left
                    if ((from_row - 1 >= 0) && (from_col - 1 >= 0)) {
                        if (!Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col - 1)))) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col - 1, color, 93);
                            }
                        }
                    }
                }
            }

        } else { //White
            listKing = new ArrayList();
            for (int i = 255; i <= 0; i--) {
                if (String.valueOf(board.charAt(i)).equals("K")) {
                    listKing.add(i);
                }
            }

            if (listKing.isEmpty() == false) {
                for (int i = 0; i < listKing.size(); i++) {
                    int index = Integer.valueOf(String.valueOf(listKing.get(i)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    //Line Up
                    if (from_row + 1 <= 15) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col, color, 118);
                            }
                        }
                    }
                    //Line Down
                    if (from_row - 1 >= 0) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col, color, 126);
                            }
                        }
                    }
                    //Line Right
                    if (from_col + 1 <= 15) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row, from_col + 1, color, 134);
                            }
                        }
                    }
                    //Line Left
                    if (from_col - 1 >= 0) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row, from_col - 1, color, 142);
                            }
                        }
                    }
                    //Diagonal Up and Right
                    if ((from_row + 1 <= 15) && (from_col + 1 <= 15)) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col + 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col + 1, color, 150);
                            }
                        }
                    }
                    //Diagonal Up and Left
                    if ((from_row + 1 <= 15) && (from_col - 1 >= 0)) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col - 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row + 1, from_col - 1, color, 158);
                            }
                        }
                    }
                    //Diagonal Down and Right
                    if ((from_row - 1 >= 0) && (from_col + 1 <= 15)) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col + 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col + 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col + 1, color, 166);
                            }
                        }
                    }
                    //Diagonal Down and Left
                    if ((from_row - 1 >= 0) && (from_col - 1 >= 0)) {
                        if (!Character.isUpperCase(board.charAt(this.calculateIndex(from_row - 1, from_col - 1)))) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - 1, from_col - 1)))) {
                                return movementDTO = new King().moveDTO(from_row, from_col, from_row - 1, from_col - 1, color, 174);
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
