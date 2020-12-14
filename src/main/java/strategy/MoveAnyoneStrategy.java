package strategy;

import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;
import pieces.Queen;
import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public class MoveAnyoneStrategy implements IStrategy {

    @Override
    public DTOMovement moveStrategy(String board, String color) {
        DTOMovement movementDTO = new DTOMovement();
        List listPawn;
        List listQueen;

        if (color.equals("black")) { //Black

            //Pawn
            listPawn = new ArrayList();
            for (int i = 111; i >= 32; i--) {
                if (String.valueOf(board.charAt(i)).equals("p")) {
                    listPawn.add(i);
                }
            }
            if (listPawn.isEmpty() == false) {
                for (int j = 0; j < listPawn.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listPawn.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);
                    if (String.valueOf(board.charAt(this.calculateIndex(j + 1, j))).equals("p")) {
                        return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col, color, 36);
                    }
                }
            }

            //Queen
            listQueen = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    listQueen.add(i);
                }
            }
            if (listQueen.isEmpty() == false) {
                for (int j = 0; j < listQueen.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listQueen.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);
                    boolean lineUp = true;
                    if (Character.isLowerCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                        lineUp = false;
                    }
                    if (lineUp == true) {
                        return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + 1, from_col, color, 58);
                    }
                }
            }

        } else { //White

            //Pawn
            listPawn = new ArrayList();
            for (int i = 144; i <= 223; i++) {
                if (String.valueOf(board.charAt(i)).equals("P")) {
                    listPawn.add(i);
                }
            }
            if (listPawn.isEmpty() == false) {
                for (int j = 0; j < listPawn.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listPawn.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);
                    if (String.valueOf(board.charAt(this.calculateIndex(j + 1, j))).equals(" ")) {
                        return movementDTO = new Pawn().moveDTO(from_row, from_col, from_row + 1, from_col, color, 78);
                    }
                }
            }

            //Queen
            listQueen = new ArrayList();
            for (int i = 0; i <= 255; i++) {
                if (String.valueOf(board.charAt(i)).equals("q")) {
                    listQueen.add(i);
                }
            }
            if (listQueen.isEmpty() == false) {
                for (int j = 0; j < listQueen.size(); j++) {
                    int index = Integer.valueOf(String.valueOf(listQueen.get(j)));
                    int from_row = this.calculateRow(index);
                    int from_col = this.calculateCol(index, from_row);
                    boolean lineUp = true;
                    if (Character.isUpperCase(board.charAt(this.calculateIndex(from_row + 1, from_col)))) {
                        lineUp = false;
                    }
                    if (lineUp == true) {
                        return movementDTO = new Queen().moveDTO(from_row, from_col, from_row + 1, from_col, color, 100);
                    }
                }
            }
        }
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
