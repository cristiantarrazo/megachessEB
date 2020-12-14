package pieces;

import transfer.DTOMovement;
import transfer.Movement;

/**
 *
 * @author Cristian Tarrazó
 */
public class King implements IPiece {

    @Override
    public boolean move(int from_row, int from_col, int to_row, int to_col, String color) {
        boolean movePossible = false;
        //Coordinate limit
        if ((from_row < 0) || (from_row > 15) || (from_col < 0) || (from_col > 15)) {
            return false;
        }
        if ((to_row < 0) || (to_row > 15) || (to_col < 0) || (to_col > 15)) {
            return false;
        }
        //Line Up
        if ((to_col == from_col) && (to_row == from_row + 1)) {
            movePossible = true;
        }
        //Line Down
        if ((to_col == from_col) && (to_row == from_row - 1)) {
            movePossible = true;
        }
        //Line Right
        if ((to_col == from_col + 1) && (to_row == from_row)) {
            movePossible = true;
        }
        //Line Left
        if ((to_col == from_col - 1) && (to_row == from_row)) {
            movePossible = true;
        }
        //Diagonal Up Right
        if ((to_col == from_col + 1) && (to_row == from_row + 1)) {
            movePossible = true;
        }
        //Diagonal Up Left
        if ((to_col == from_col - 1) && (to_row == from_row + 1)) {
            movePossible = true;
        }
        //Diagonal Down Right
        if ((to_col == from_col + 1) && (to_row == from_row - 1)) {
            movePossible = true;
        }
        //Diagonal Down Left
        if ((to_col == from_col - 1) && (to_row == from_row -1)) {
            movePossible = true;
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
            System.out.println("King: Movement Fail - From_row: " + from_row + " From_col: " + from_col + " To_row: " + to_row + " To_col: " + to_col + " - Line Code: " + lineCodeCall);
            movementDTO.setApply(false);
            return movementDTO;
        }
    }

}
