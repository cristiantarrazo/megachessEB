package pieces;

import transfer.DTOMovement;
import transfer.Movement;

/**
 *
 * @author Cristian Tarrazó
 */
public class Rook implements IPiece{

    @Override
    public boolean move(int from_row, int from_col, int to_row, int to_col, String color) {
        boolean movePossible = false;
        int stepRow;
        int stepCol;

        //Coordinate limit
        if ((from_row < 0) || (from_row > 15) || (from_col < 0) || (from_col > 15)) {
            return false;
        }
        if ((to_row < 0) || (to_row > 15) || (to_col < 0) || (to_col > 15)) {
            return false;
        }
        if((from_row == to_row) && (from_col == to_col)){
            return false;
        }

        //Line Up or Line Down Move Steps
        if (from_row < to_row) {
            stepRow = to_row - from_row;
        } else {
            stepRow = from_row - to_row;
        }

        //Line Left or Line Right Move Steps
        if (from_col < to_col) {
            stepCol = to_col - from_col;
        } else {
            stepCol = from_col - to_col;
        }

        //Line Up or Line Down Move
        if ((stepCol == 0) && (stepCol < stepRow)) {
            if ((from_col == to_col) && (to_row == from_row + stepRow)) {
                movePossible = true;
            }
            if ((from_col == to_col) && (to_row == from_row - stepRow)) {
                movePossible = true;
            }
        }

        //Line Left or Line Right Move
        if ((stepRow == 0) && (stepRow < stepCol)) {
            if ((from_row == to_row) && (to_col == from_col + stepCol)) {
                movePossible = true;
            }
            if ((from_row == to_row) && (to_col == from_col - stepCol)) {
                movePossible = true;
            }
        }
        return movePossible;
    }
    
    public DTOMovement moveDTO(int from_row, int from_col, int to_row, int to_col, String color, int lineCodeCall) {
        DTOMovement movementDTO = new DTOMovement();
        Movement movement = new Movement();
        if (this.move(from_row, from_col, to_row, to_col, color)) {
            movementDTO.setApply(true);
            movement.setFrom_row(from_row);
            movement.setFrom_col(from_col);
            movement.setTo_row(to_row);
            movement.setTo_col(to_col);
            movementDTO.setMovement(movement);
            return movementDTO;
        } else {
            System.out.println("Rook: Movement Fail - From_row: " + from_row + " From_col: " + from_col + " To_row: " + to_row + " To_col: " + to_col + " - Line Code: " + lineCodeCall);
            movementDTO.setApply(false);
            return movementDTO;
        }
    }
}
