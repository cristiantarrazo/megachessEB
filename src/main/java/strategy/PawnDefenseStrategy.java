package strategy;

import transfer.DTOMovement;
import pieces.Pawn;

/**
 *
 * @author Cristian Tarrazó
 */
public class PawnDefenseStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();

        //Choose color piece
        if (color.equals("black")) { //Black
            for (int i = 32; i <= 111; i++) {// From row 2 to 6
                if (String.valueOf(board.charAt(i)).equals("p")) {
                    //Black pawn defense col 0, row 2 and 3
                    if ((i == 32) || (i == 48)) {
                        if (Character.isUpperCase(board.charAt(i + 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col + 1, color, 25);
                        }
                    }
                    //Black pawn defense col 15, row 2 and 3
                    if ((i == 47) || (i == 63)) {
                        if (Character.isUpperCase(board.charAt(i + 15))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col - 1, color, 33);
                        }
                    }

                    //Black pawn defense row 2, from col 1 to 14
                    if ((i >= 33) && (i <= 46)) {
                        if (Character.isUpperCase(board.charAt(i + 15))) {
                            if (Character.isUpperCase(board.charAt(i + 15))) {
                                int from_row = this.calculateRow(i);
                                int from_col = this.calculateCol(i, from_row);
                                return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col - 1, color, 43);
                            }
                        }
                        if (Character.isUpperCase(board.charAt(i + 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col + 1, color, 49);
                        }
                    }

                    //Black pawn defense row 3, from col 1 to 14
                    if ((i >= 49) && (i <= 62)) {
                        if (Character.isUpperCase(board.charAt(i + 15))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col - 1, color, 58);
                        }
                        if (Character.isUpperCase(board.charAt(i + 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col + 1, color, 63);
                        }
                    }
                }
            }
        } else { //White
            for (int i = 144; i <= 223; i++) {
                if (String.valueOf(board.charAt(i)).equals("P")) {
                    //White pawn defense col 0, row 12 and 13
                    if ((i == 192) || (i == 208)) {
                        if (Character.isLowerCase(board.charAt(i - 15))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col + 1, color, 76);
                        }
                    }
                    //White pawn defense col 15, row 12 and 13
                    if ((i == 207) || (i == 223)) {
                        if (Character.isLowerCase(board.charAt(i - 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col - 1, color, 84);
                        }
                    }
                    //White pawn defense row 12, from col 1 to 14
                    if ((i >= 193) && (i <= 206)) {
                        if (Character.isLowerCase(board.charAt(i - 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col - 1, color, 92);
                        }
                        if (Character.isLowerCase(board.charAt(i - 15))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col + 1, color, 97);
                        }
                    }
                    //White pawn defense row 13, from col 1 to 14
                    if ((i >= 209) && (i <= 222)) {
                        if (Character.isLowerCase(board.charAt(i - 17))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col - 1, color, 105);
                        }
                        if (Character.isLowerCase(board.charAt(i - 15))) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col + 1, color, 110);
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
}