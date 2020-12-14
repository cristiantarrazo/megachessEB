/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.Rook;
import transfer.DTOMovement;

/**
 *
 * @author crist
 */
public class RookBarrierStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listRookRow9;
        List listRookRow8;

        if (color.equals("black")) { //Black

            //Barrier Row 9
            listRookRow9 = new ArrayList();
            for (int i = 144; i <= 159; i++) {
                if (String.valueOf(board.charAt(i)).equals("r")) {
                    listRookRow9.add(i);
                }
            }
            if (listRookRow9.isEmpty() == false) {
                movementDTO = this.moveBarrier(listRookRow9, board, color);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            } else {
                movementDTO = this.moveRowBarrier(listRookRow9, board, color, 9);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            }

            //Barrier Row 8
            listRookRow8 = new ArrayList();
            for (int i = 144; i <= 159; i++) {
                if (String.valueOf(board.charAt(i)).equals("r")) {
                    listRookRow8.add(i);
                }
            }
            if (listRookRow8.isEmpty() == false) {
                movementDTO = this.moveBarrier(listRookRow8, board, color);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            } else {
                movementDTO = this.moveRowBarrier(listRookRow8, board, color, 8);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            }

        } else { //White
            List listRookRow5;
            List listRookRow6;
            //Barrier Row 5
            listRookRow5 = new ArrayList();
            for (int i = 144; i <= 159; i++) {
                if (String.valueOf(board.charAt(i)).equals("R")) {
                    listRookRow5.add(i);
                }
            }
            if (listRookRow5.isEmpty() == false) {
                movementDTO = this.moveBarrier(listRookRow5, board, color);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            } else {
                movementDTO = this.moveRowBarrier(listRookRow5, board, color, 9);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            }

            //Barrier Row 8
            listRookRow6 = new ArrayList();
            for (int i = 144; i <= 159; i++) {
                if (String.valueOf(board.charAt(i)).equals("R")) {
                    listRookRow6.add(i);
                }
            }
            if (listRookRow6.isEmpty() == false) {
                movementDTO = this.moveBarrier(listRookRow6, board, color);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            } else {
                movementDTO = this.moveRowBarrier(listRookRow6, board, color, 8);
                if (movementDTO.isApply() == true) {
                    return movementDTO;
                }
            }
        }
        movementDTO.setApply(false);
        return movementDTO;
    }

    private DTOMovement moveBarrier(List listRook, String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        if (color.endsWith("black")) {
            for (int j = 0; j < listRook.size(); j++) {
                int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                int from_row = this.calculateRow(index);
                int from_col = this.calculateCol(index, from_row);

                boolean lineRight = true;
                boolean lineLeft = true;

                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            lineRight = false;
                        }
                        if (lineRight == true) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col + i, color, 129);
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
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col - i, color, 140);
                            }
                        }
                    }
                }
            }
        } else {
            for (int j = 0; j < listRook.size(); j++) {
                int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                int from_row = this.calculateRow(index);
                int from_col = this.calculateCol(index, from_row);

                boolean lineRight = true;
                boolean lineLeft = true;

                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            lineRight = false;
                        }
                        if (lineRight == true) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col + i, color, 163);
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
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row, from_col - i, color, 174);
                            }
                        }
                    }
                }
            }
        }

        movementDTO.setApply(false);
        return movementDTO;
    }

    private DTOMovement moveRowBarrier(List listRook, String board, String color, int to_row) {
        DTOMovement movementDTO = new DTOMovement();
        if (color.equals("black")) {
            for (int j = 0; j < listRook.size(); j++) {
                int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                int from_row = this.calculateRow(index);
                int from_col = this.calculateCol(index, from_row);

                boolean lineUp = true;
                boolean lineDown = true;

                for (int i = 1; i <= 15; i++) {
                    //Line Up
                    if (from_row + i <= to_row) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                            lineUp = false;
                        }
                        if (lineUp == true) {
                            if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row + i, from_col, color, 205);
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
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row - i, from_col, color, 216);
                            }
                        }
                    }
                }
            }
        } else {
            for (int j = 0; j < listRook.size(); j++) {
                int index = Integer.valueOf(String.valueOf(listRook.get(j)));
                int from_row = this.calculateRow(index);
                int from_col = this.calculateCol(index, from_row);

                boolean lineUp = true;
                boolean lineDown = true;

                for (int i = 1; i <= 15; i++) {
                    //Line Up
                    if (from_row + i <= to_row) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                            lineUp = false;
                        }
                        if (lineUp == true) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + i, from_col)))) {
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row + i, from_col, color, 239);
                            }
                        }
                    }
                    //Line Down
                    if (from_row - i >= 0) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                            lineDown = false;
                        }
                        if (lineDown == true) {
                            if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row - i, from_col)))) {
                                return movementDTO = new Rook().moveDTO(from_row, from_col, from_row - i, from_col, color, 250);
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
