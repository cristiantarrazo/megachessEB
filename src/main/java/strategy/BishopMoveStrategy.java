package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.Bishop;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class BishopMoveStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listBishop;

        if (color.equals("black")) { //Black
            listBishop = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("b")) {
                    listBishop.add(i);
                }
            }

            if (listBishop.isEmpty() == false) {
                for (int j = 0; j < listBishop.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listBishop.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean diagonalUpRight = true;
                    boolean diagonalUpLeft = true;
                    boolean diagonalDownRight = true;
                    boolean diagonalDownLeft = true;

                    for (int i = 1; i <= 15; i++) {
                        //Diagonal Up and Right
                        if ((from_row + i <= 15) && (from_col + i <= 15)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                diagonalUpRight = false;
                            }
                            if (diagonalUpRight == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row + i, from_col + i, color, 46);
                                }
                            }
                        }
                        //Diagonal Up and Left
                        if ((from_row + i <= 15) && (from_col - i >= 0)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                diagonalUpLeft = false;
                            }
                            if (diagonalUpLeft == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row + i, from_col - i, color, 57);
                                }
                            }
                        }
                        //Diagonal Down and Right
                        if ((from_row - i >= 0) && (from_col + i <= 15)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                diagonalDownRight = false;
                            }
                            if (diagonalDownRight == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row - i, from_col + i, color, 68);
                                }
                            }
                        }
                        //Diagonal Down and Left
                        if ((from_row - i >= 0) && (from_col - i >= 0)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                diagonalDownLeft = false;
                            }
                            if (diagonalDownLeft == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row - i, from_col - i, color, 79);
                                }
                            }
                        }
                    }
                }
            }
        } else { //White
            listBishop = new ArrayList();
            for (int i = 255; i >= 0; i--) {
                if (String.valueOf(board.charAt(i)).equals("B")) {
                    listBishop.add(i);
                }
            }

            if (listBishop.isEmpty() == false) {
                for (int j = 0; j < listBishop.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listBishop.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean diagonalUpRight = true;
                    boolean diagonalUpLeft = true;
                    boolean diagonalDownRight = true;
                    boolean diagonalDownLeft = true;

                    for (int i = 1; i <= 15; i++) {
                        //Diagonal Up and Right
                        if ((from_row + i <= 15) && (from_col + i <= 15)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                diagonalUpRight = false;
                            }
                            if (diagonalUpRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row + i, from_col + i, color, 113);
                                }
                            }
                        }
                        //Diagonal Up and Left
                        if ((from_row + i <= 15) && (from_col - i >= 0)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                diagonalUpLeft = false;
                            }
                            if (diagonalUpLeft == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row + i, from_col - i, color, 124);
                                }
                            }
                        }
                        //Diagonal Down and Right
                        if ((from_row - i >= 0) && (from_col + i <= 15)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                diagonalDownRight = false;
                            }
                            if (diagonalDownRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row - i, from_col + i, color, 135);
                                }
                            }
                        }
                        //Diagonal Down and Left
                        if ((from_row - i >= 0) && (from_col - i >= 0)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                diagonalDownLeft = false;
                            }
                            if (diagonalDownLeft == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                    return movementDTO = new Bishop().moveDTO(from_row, from_col, from_row - i, from_col - i, color, 146);
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
