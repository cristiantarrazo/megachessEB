package strategy;

import java.util.Random;
import transfer.DTOMovement;
import pieces.Pawn;

/**
 *
 * @author Cristian Tarrazó
 */
public class PawnMoveStrategy implements IStrategy {

    private final Random nroRandom = new Random();

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();

        boolean firstMove = true;
        //Choose color piece
        if (color.equals("black")) { //Black
            //Scroll if the line is full
            for (int i = 48; i <= 63; i++) {
                if (!String.valueOf(board.charAt(i)).equals("p")) {
                    firstMove = false;
                }
            }

            if (firstMove == true) {
                //First move to row 3
                for (int i = 160; i >= 191; i++) {
                    //The black pieces are the second turn of movement, look for which white piece moved
                    if (Character.isUpperCase(board.charAt(i))) {
                        //If the white piece moved one place, advance a black piece in the same col
                        if ((i >= 176) || (i <= 191)) {
                            int from_col = this.calculateCol(i, 11);
                            return movementDTO = new Pawn().moveDTO(3, from_col, 5, from_col, color, 37);
                        }
                        //If the white piece moved two place, advance a black piece in the another col
                        if ((i >= 160) || (i <= 167)) {
                            int from_col = this.calculateCol(i + 2, 10);
                            return movementDTO = new Pawn().moveDTO(3, from_col, 5, from_col, color, 42);
                        } else if ((i >= 168) || (i <= 175)) {
                            int from_col = this.calculateCol(i - 2, 10);
                            return movementDTO = new Pawn().moveDTO(3, from_col, 5, from_col, color, 45);
                        }
                    }
                }
                //If the other player did not move any pieces, move random
                int from_col = nroRandom.nextInt(16);
                int index = 48 + from_col;
                if (String.valueOf(board.charAt(index + 16)).equals(" ")) {
                    return movementDTO = new Pawn().moveDTO(3, from_col, 5, from_col, color, 53);
                }
            } else {
                //If the row is not complete and there are pawns on the board, choose one and advance
                for (int i = 64; i <= 111; i++) {
                    if (String.valueOf(board.charAt(i)).equals("p")) {
                        if (String.valueOf(board.charAt(i + 16)).equals(" ")) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col, color, 62);
                        }
                    }
                }
                //Advance row 3
                int indexRightRow3 = 63;
                for (int i = 48; i <= 50; i++) {
                    if (String.valueOf(board.charAt(i)).equals("p")) {
                        //Advance left
                        if (String.valueOf(board.charAt(i + 16)).equals(" ")) {
                            int from_col = this.calculateCol(i, 3);
                            return movementDTO = new Pawn().moveDTO(3, from_col, 4, from_col, color, 73);
                        }
                    } else if (String.valueOf(board.charAt(indexRightRow3)).equals("p")) {
                        //Advance right
                        if (String.valueOf(board.charAt(indexRightRow3 + 16)).equals(" ")) {
                            int from_col = this.calculateCol(indexRightRow3, 3);
                            return movementDTO = new Pawn().moveDTO(3, from_col, 4, from_col, color, 79);
                        }
                    }
                    indexRightRow3--;
                }

                //Advance row 2
                int indexRightRow2 = 47;
                for (int i = 32; i <= 34; i++) {
                    if (String.valueOf(board.charAt(i)).equals("p")) {
                        //Advance left
                        if (String.valueOf(board.charAt(i + 16)).equals(" ")) {
                            int from_col = this.calculateCol(i, 2);
                            return movementDTO = new Pawn().moveDTO(2, from_col, 3, from_col, color, 92);
                        }
                    } else if (String.valueOf(board.charAt(indexRightRow2)).equals("p")) {
                        //Advance right
                        if (String.valueOf(board.charAt(indexRightRow2 + 16)).equals(" ")) {
                            int from_col = this.calculateCol(indexRightRow2, 2);
                            return movementDTO = new Pawn().moveDTO(2, from_col, 3, from_col, color, 98);
                        }
                    }
                    indexRightRow2--;
                }
            }
            //Consecutive advance initial rows
            for (int i = 111; i >= 32; i--) {
                if (String.valueOf(board.charAt(i)).equals("p")) {
                    int from_row = this.calculateRow(i);
                    int from_col = this.calculateCol(i, from_row);
                    if (String.valueOf(board.charAt(i + 16)).equals(" ")) {
                        return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col, color, 110);
                    }
                }
            }
        } else {  //White
            //Scroll if the line is full
            for (int i = 192; i <= 207; i++) {
                if (!String.valueOf(board.charAt(i)).equals("P")) {
                    firstMove = false;
                }
            }

            if (firstMove == true) {
                //First move to row 12
                int from_col = nroRandom.nextInt(16);
                int index = (12 * 16) + from_col;
                if (String.valueOf(board.charAt(index - 16)).equals(" ")) {
                    return movementDTO = new Pawn().moveDTO(12, from_col, 10, from_col, color, 127);
                }
            } else {
                //If the row is not complete and there are pawns on the board, choose one and advance
                for (int i = 144; i <= 191; i++) {
                    if (String.valueOf(board.charAt(i)).equals("P")) {
                        if (String.valueOf(board.charAt(i - 16)).equals(" ")) {
                            int from_row = this.calculateRow(i);
                            int from_col = this.calculateCol(i, from_row);
                            return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col, color, 136);
                        }
                    }
                }

                //Advence row 12
                int indexRightRow12 = 207;
                for (int i = 192; i <= 194; i++) {
                    //Advance left
                    if (String.valueOf(board.charAt(i)).equals("P")) {
                        if (String.valueOf(board.charAt(i - 16)).equals(" ")) {
                            int from_col = this.calculateCol(i, 12);
                            return movementDTO = new Pawn().moveDTO(12, from_col, 11, from_col, color, 148);
                        }
                    } else if (String.valueOf(board.charAt(indexRightRow12)).equals("P")) {
                        //Advance right
                        if (String.valueOf(board.charAt(indexRightRow12 - 16)).equals(" ")) {
                            int from_col = this.calculateCol(indexRightRow12, 12);
                            return movementDTO = new Pawn().moveDTO(12, from_col, 11, from_col, color, 154);
                        }
                    }
                    indexRightRow12--;
                }

                //Advance ro 13
                int indexRightRow13 = 223;
                for (int i = 208; i <= 210; i++) {
                    //Advance left
                    if (String.valueOf(board.charAt(i)).equals("P")) {
                        if (String.valueOf(board.charAt(i - 16)).equals(" ")) {
                            int from_col = this.calculateCol(i, 13);
                            return movementDTO = new Pawn().moveDTO(13, from_col, 12, from_col, color, 167);
                        }
                    } else if (String.valueOf(board.charAt(indexRightRow13)).equals("P")) {
                        //Advance right
                        if (String.valueOf(board.charAt(indexRightRow13 - 16)).equals(" ")) {
                            int from_col = this.calculateCol(indexRightRow13, 13);
                            return movementDTO = new Pawn().moveDTO(13, from_col, 12, from_col, color, 173);
                        }
                    }
                    indexRightRow13--;
                }
            }
            //Consecutive advance initial rows
            for (int i = 144; i <= 223; i++) {
                if (String.valueOf(board.charAt(i)).equals("P")) {
                    int from_row = this.calculateRow(i);
                    int from_col = this.calculateCol(i, from_row);
                    if (String.valueOf(board.charAt(i - 16)).equals(" ")) {
                        return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row - 1, from_col, color, 185);
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
