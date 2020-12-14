package strategy;

import pieces.Queen;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class QueenBarrierStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();

        //Choose color piece
        if (color.equals("black")) { //Black
            //Row 10 - Index 160 to 175
            int indexWhitePieceRow10 = 0;
            for (int i = 160; i <= 175; i++) {
                if (Character.isUpperCase(board.charAt(i))) {
                    indexWhitePieceRow10 = i;
                }
            }

            //Row 9 - Index 144 to 159
            int queenRow9 = 0;
            int indexBlackQueenRow9 = 0;
            int indexWhitePieceRow9 = 0;
            for (int i = 144; i <= 159; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    queenRow9 = queenRow9 + 1;
                    indexBlackQueenRow9 = i;
                }
                if (Character.isUpperCase(board.charAt(i))) {
                    indexWhitePieceRow9 = i;
                }
            }

            //Row 8 - Index 128 to 143
            int queenRow8 = 0;
            int indexWhitePieceRow8 = 0;
            int indexBlackQueenRow8 = 0;
            for (int i = 128; i <= 143; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    queenRow8 = queenRow8 + 1;
                    indexBlackQueenRow8 = i;
                }
                if (Character.isUpperCase(board.charAt(i))) {
                    indexWhitePieceRow8 = i;
                }
            }

            //Row 7 - Index 112 to 127
            int queenRow7 = 0;
            int indexBlackQueenRow7 = 0;
            for (int i = 112; i <= 127; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    queenRow7 = queenRow7 + 1;
                    indexBlackQueenRow7 = i;
                }
            }

            //Row 9 move barrier
            if ((indexBlackQueenRow9 != 0) && (indexWhitePieceRow9 != 0)) {
                int from_row = this.calculateRow(indexBlackQueenRow9);
                int from_col = this.calculateCol(indexBlackQueenRow9, from_row);
                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 72);
                        }
                    }
                    //Line Left
                    if (from_col - i >= 0) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 76);
                        }
                    }
                }
            }

            //Row 8 move barrier
            if ((indexBlackQueenRow8 != 0) && (indexWhitePieceRow8 != 0)) {
                int from_row = this.calculateRow(indexBlackQueenRow8);
                int from_col = this.calculateCol(indexBlackQueenRow8, from_row);
                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 91);
                        }
                    }
                    //Line Left
                    if (from_col - i >= 0) {
                        if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 98);
                        }
                    }
                }
            }

            //Row 7 
            if (queenRow7 >= 1) {
                if (queenRow9 == 0) {
                    int from_col = this.calculateCol(indexBlackQueenRow7, 7);
                    if (Character.isUpperCase(board.charAt(indexBlackQueenRow7 + 16))) {
                        return movementDTO = new Queen().moveDTO(7, from_col, 8, from_col, color, 109);
                    }
                    if ((String.valueOf(board.charAt(indexBlackQueenRow7 + 16)).equals(" "))) {
                        if ((String.valueOf(board.charAt(indexBlackQueenRow7 + 32)).equals(" ")) || (Character.isUpperCase(board.charAt(indexBlackQueenRow7 + 32)))) {
                            return movementDTO = new Queen().moveDTO(7, from_col, 9, from_col, color, 113);
                        }
                    }
                }
                if (queenRow8 == 0) {
                    int from_col = this.calculateCol(indexBlackQueenRow7, 7);
                    if ((String.valueOf(board.charAt(indexBlackQueenRow7 + 16)).equals(" ")) || (Character.isUpperCase(board.charAt(indexBlackQueenRow7 + 16)))) {
                        return movementDTO = new Queen().moveDTO(7, from_col, 8, from_col, color, 120);
                    }
                }
                if ((queenRow9 > 0) && (queenRow8 > 0)) {
                    int i = indexBlackQueenRow7;
                    int from_col = this.calculateCol(indexBlackQueenRow7, 7);
                    while (i < 255) {
                        i = i + 16;
                        if (!Character.isLowerCase(board.charAt(i))) {
                            if (Character.isUpperCase(board.charAt(i))) {
                                int to_row = this.calculateRow(i);
                                return movementDTO = new Queen().moveDTO(7, from_col, to_row, from_col, color, 131);
                            }
                            if ((i >= 240) || (i <= 255)) {
                                int to_row = this.calculateRow(i);
                                return movementDTO = new Queen().moveDTO(7, from_col, to_row, from_col, color, 135);
                            }
                        }
                    }
                }
            }

        } else { //Wihite
            //Row 5 - Index 80 to 95
            int indexBlackPieceRow5 = 0;
            for (int i = 80; i <= 95; i++) {
                if (Character.isLowerCase(board.charAt(i))) {
                    indexBlackPieceRow5 = i;
                }
            }

            //Row 6 - Index 96 to 111
            int queenRow6 = 0;
            int indexWhiteQueenRow6 = 0;
            int indexBlackPieceRow6 = 0;
            for (int i = 96; i <= 111; i++) {
                if (String.valueOf(board.charAt(i)).equals("Q")) {
                    queenRow6 = queenRow6 + 1;
                    indexWhiteQueenRow6 = i;
                }
                if (Character.isLowerCase(board.charAt(i))) {
                    indexBlackPieceRow6 = i;
                }
            }

            //Row 7 - Index 112 to 127
            int queenRow7 = 0;
            int indexBlackPieceRow7 = 0;
            int indexWhiteQueenRow7 = 0;
            for (int i = 128; i <= 143; i++) {
                if (String.valueOf(board.charAt(i)).equals("Q")) {
                    queenRow7 = queenRow7 + 1;
                    indexWhiteQueenRow7 = i;
                }
                if (Character.isLowerCase(board.charAt(i))) {
                    indexBlackPieceRow7 = i;
                }
            }

            //Row 8 - Index 128 to 143
            int queenRow8 = 0;
            int indexWhiteQueenRow8 = 0;
            for (int i = 112; i <= 127; i++) {
                if (String.valueOf(board.charAt(i)).equals("Q")) {
                    queenRow8 = queenRow8 + 1;
                    indexWhiteQueenRow8 = i;
                }
            }

            //Row 6 move barrier
            if ((indexWhiteQueenRow6 != 0) && (indexBlackPieceRow6 != 0)) {
                int from_row = this.calculateRow(indexWhiteQueenRow6);
                int from_col = this.calculateCol(indexWhiteQueenRow6, from_row);
                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 195);
                        }
                    }
                    //Line Left
                    if (from_col - i >= 0) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 203);
                        }
                    }
                }
            }

            //Row 7 move barrier
            if ((indexWhiteQueenRow7 != 0) && (indexBlackPieceRow7 != 0)) {
                int from_row = this.calculateRow(indexWhiteQueenRow7);
                int from_col = this.calculateCol(indexWhiteQueenRow7, from_row);
                for (int i = 1; i <= 15; i++) {
                    //Line Right
                    if (from_col + i <= 15) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col + i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col + i, color, 217);
                        }
                    }
                    //Line Left
                    if (from_col - i >= 0) {
                        if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row, from_col - i)))) {
                            return movementDTO = new Queen().moveDTO(from_row, from_col, from_row, from_col - i, color, 223);
                        }
                    }
                }
            }

            //Row 8 
            if (queenRow8 >= 1) {
                if (queenRow6 == 0) {
                    int from_col = this.calculateCol(indexWhiteQueenRow8, 8);
                    if (Character.isLowerCase(board.charAt(indexWhiteQueenRow8 - 16))) {
                        return movementDTO = new Queen().moveDTO(8, from_col, 7, from_col, color, 306);
                    }
                    if ((String.valueOf(board.charAt(indexWhiteQueenRow8 - 16)).equals(" "))) {
                        if ((String.valueOf(board.charAt(indexWhiteQueenRow8 - 32)).equals(" ")) || (Character.isLowerCase(board.charAt(indexWhiteQueenRow8 - 32)))) {
                            return movementDTO = new Queen().moveDTO(8, from_col, 6, from_col, color, 238);
                        }
                    }
                }
                if (queenRow7 == 0) {
                    int from_col = this.calculateCol(indexWhiteQueenRow8, 8);
                    if ((String.valueOf(board.charAt(indexWhiteQueenRow8 - 16)).equals(" ")) || (Character.isLowerCase(board.charAt(indexWhiteQueenRow8 - 16)))) {
                        return movementDTO = new Queen().moveDTO(8, from_col, 7, from_col, color, 245);
                    }
                }
                if ((queenRow6 > 0) && (queenRow7 > 0)) {
                    int i = indexWhiteQueenRow8;
                    int from_col = this.calculateCol(indexWhiteQueenRow8, 8);
                    while (i < 0) {
                        i = i - 16;
                        if (Character.isUpperCase(board.charAt(i))) {
                            if (Character.isLowerCase(board.charAt(i))) {
                                int to_row = this.calculateRow(i);
                                return movementDTO = new Queen().moveDTO(7, from_col, to_row, from_col, color, 256);
                            }
                            if ((i >= 240) || (i <= 255)) {
                                int to_row = this.calculateRow(i);
                                return movementDTO = new Queen().moveDTO(7, from_col, to_row, from_col, color, 260);
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
