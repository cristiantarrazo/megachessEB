package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.Queen;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class QueenMoveStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listQueen;

        if (color.equals("black")) { //Black
            listQueen = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    listQueen.add(i);
                }
            }
            if (listQueen.isEmpty() == false) {
                int stepLimit = 15;
                if (listQueen.size() < 10) {
                    stepLimit = 8;
                }
                for (int i = 144; i < 255; i++) {
                    if (String.valueOf(board.charAt(i)).equals("q")) {
                        stepLimit = 15;
                    }
                }
                for (int i = 144; i <= 159; i++) {
                    if(Character.isUpperCase(i)){
                        stepLimit = 9;
                    }
                }
                for (int j = 0; j < listQueen.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listQueen.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean lineUp = true;
                    boolean lineDown = true;
                    boolean lineRight = true;
                    boolean lineLeft = true;
                    boolean diagonalUpRight = true;
                    boolean diagonalUpLeft = true;
                    boolean diagonalDownRight = true;
                    boolean diagonalDownLeft = true;
                    for (int i = 1; i <= 15; i++) {
                        //Line Right
                        if (from_col + i <= 15) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                lineRight = false;
                            }
                            if (lineRight == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 62);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 73);
                                }
                            }
                        }
                        //Line Up
                        if (from_row + i <= stepLimit) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                lineUp = false;
                            }
                            if (lineUp == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col, color, 84);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col, color, 95);
                                }
                            }
                        }
                        //Diagonal Up and Right
                        if ((from_row + i <= stepLimit) && (from_col + i <= 15)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                diagonalUpRight = false;
                            }
                            if (diagonalUpRight == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col + i, color, 106);
                                }
                            }
                        }
                        //Diagonal Up and Left
                        if ((from_row + i <= stepLimit) && (from_col - i >= 0)) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                diagonalUpLeft = false;
                            }
                            if (diagonalUpLeft == true) {
                                if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col - i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col - i, color, 117);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col + i, color, 128);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col - i, color, 139);
                                }
                            }
                        }
                    }
                }
            }
        } else { //White
            listQueen = new ArrayList();
            for (int i = 255; i >= 0; i--) {
                if (String.valueOf(board.charAt(i)).equals("Q")) {
                    listQueen.add(i);
                }
            }

            if (listQueen.isEmpty() == false) {
                int stepLimit = 0;
                if (listQueen.size() < 10) {
                    stepLimit = 7;
                }
                for (int i = 111; i < 0; i--) {
                    if (String.valueOf(board.charAt(i)).equals("Q")) {
                        stepLimit = 0;
                    }
                }
                for (int i = 111; i <= 96; i--) {
                    if(Character.isLowerCase(i)){
                        stepLimit = 6;
                    }
                }

                for (int j = 0; j < listQueen.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listQueen.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);

                    boolean lineUp = true;
                    boolean lineDown = true;
                    boolean lineRight = true;
                    boolean lineLeft = true;
                    boolean diagonalUpRight = true;
                    boolean diagonalUpLeft = true;
                    boolean diagonalDownRight = true;
                    boolean diagonalDownLeft = true;

                    for (int i = 1; i <= 15; i++) {
                        //Line Right
                        if (from_col + i <= 15) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                lineRight = false;
                            }
                            if (lineRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 192);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 203);
                                }
                            }
                        }
                        //Line Up
                        if (from_row + i <= 15) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                lineUp = false;
                            }
                            if (lineUp == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col, color, 214);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col, color, 225);
                                }
                            }
                        }
                        //Diagonal Up and Right
                        if ((from_row + i <= 15) && (from_col + i <= 15)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                diagonalUpRight = false;
                            }
                            if (diagonalUpRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col + i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col + i, color, 236);
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
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + i, from_col - i, color, 247);
                                }
                            }
                        }
                        //Diagonal Down and Right
                        if ((from_row - i >= stepLimit) && (from_col + i <= 15)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                diagonalDownRight = false;
                            }
                            if (diagonalDownRight == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col + i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col + i, color, 258);
                                }
                            }
                        }
                        //Diagonal Down and Left
                        if ((from_row - i >= stepLimit) && (from_col - i >= 0)) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                diagonalDownLeft = false;
                            }
                            if (diagonalDownLeft == true) {
                                if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col - i)))) {
                                    return movementDTO = new Queen().moveDTO(from_row, from_col, from_row - i, from_col - i, color, 269);
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
