package logic;

import transfer.Movement;
import transfer.DTOMovement;
import strategy.PawnMoveStrategy;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import strategy.BishopMoveStrategy;
import strategy.KingMoveStrategy;
import strategy.MoveAnyoneStrategy;
import strategy.PawnDefenseStrategy;
import strategy.QueenMoveStrategy;
import strategy.RookMoveStrategy;

public class GameLogic {

    private final Random nroRandom = new Random();
    private DTOMovement movementDTO;
    private Movement moveAction;

    public Movement moveStrategy(String color, String board, String moveLeft, String username) {

        this.printBoard(color, board, moveLeft, username);
        
        //Strategy King Move
        movementDTO = new KingMoveStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("King Move " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }
        
        //Strategy Bishop Move
        movementDTO = new BishopMoveStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Bishop Move " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }
        /*
        //Strategy Rook Barrier
        movementDTO = new RookBarrierStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Rook Barrier " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }
        */
        //Strategy Rook Move
        movementDTO = new RookMoveStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Rook Move " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }

        //Strategy Pawn Defense
        movementDTO = new PawnDefenseStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Pawn Defense " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }

        //Strategy Queen Move
        movementDTO = new QueenMoveStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Queen Move " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }
        
        //Strategy Move Pawn
        movementDTO = new PawnMoveStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Pawn Move " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }

        // Strategy Move Anyone
        movementDTO = new MoveAnyoneStrategy().moveStrategy(board, color);
        if (movementDTO.isApply()) {
            moveAction = new Movement();
            moveAction.setFrom_row(movementDTO.getMovement().getFrom_row());
            moveAction.setFrom_col(movementDTO.getMovement().getFrom_col());
            moveAction.setTo_row(movementDTO.getMovement().getTo_row());
            moveAction.setTo_col(movementDTO.getMovement().getTo_col());
            System.out.println("Move Anyone " + color + ": From_row: " + movementDTO.getMovement().getFrom_row() + " From_col: " + movementDTO.getMovement().getFrom_col() + " To_row: " + movementDTO.getMovement().getTo_row() + " To_col: " + movementDTO.getMovement().getTo_col());
            return moveAction;
        }
        
        System.out.println("No deberia llegar aca!!!!...");
        return moveAction = null;
    }

    public List moveRandom(String color, String board, String moveLeft) {
        List moveAction = new ArrayList();

        int indRandom = 0;
        int fromRow = 0;
        int fromCol = 0;
        int toRow = 0;
        int toCol = 0;
        boolean movePiece = false;

        //Print board and check move
        System.out.println("Color Turn: " + color + " Move Left: " + moveLeft);
        for (int i = 0; i < board.length(); i++) {
            System.out.print(board.charAt(i));
            if ((i == 15) || (i == 31) || (i == 47) || (i == 63) || (i == 79) || (i == 95)
                    || (i == 111) || (i == 127) || (i == 143) || (i == 159) || (i == 175)
                    || (i == 191) || (i == 207) || (i == 223) || (i == 239) || (i == 255)) {
                System.out.println("");
            }
        }

        if (color.equals("black")) {
            while (movePiece == false) {
                indRandom = nroRandom.nextInt(255);
                if (String.valueOf(board.charAt(indRandom)).equals("p") || String.valueOf(board.charAt(indRandom)).equals("q")) {
                    if (String.valueOf(board.charAt(indRandom + 16)).equals("p") || String.valueOf(board.charAt(indRandom + 16)).equals("q")) {
                        fromRow = (indRandom + 16) / 16; //Indice del String / 16
                        fromCol = (indRandom + 16) - (fromRow * 16); // Indice del String - Inicio de la fila
                        toRow = fromRow + 1;
                        toCol = fromCol;
                        movePiece = true;
                    } else {
                        fromRow = indRandom / 16; //Indice del String / 16
                        fromCol = indRandom - (fromRow * 16); // Indice del String - Inicio de la fila
                        toRow = fromRow + 1;
                        toCol = fromCol;
                        movePiece = true;
                    }
                }
            }
        } else {
            while (movePiece == false) {
                indRandom = nroRandom.nextInt(255);
                if (String.valueOf(board.charAt(indRandom)).equals("P") || String.valueOf(board.charAt(indRandom)).equals("Q")) {
                    if (String.valueOf(board.charAt(indRandom - 16)).equals("P") || String.valueOf(board.charAt(indRandom - 16)).equals("Q")) {
                        fromRow = (indRandom - 16) / 16; //Indice del String / 16
                        fromCol = (indRandom - 16) - (fromRow * 16); // Indice del String - Inicio de la fila
                        toRow = fromRow - 1;
                        toCol = fromCol;
                        movePiece = true;
                    } else {
                        fromRow = indRandom / 16; //Indice del String / 16
                        fromCol = indRandom - (fromRow * 16); // Indice del String - Inicio de la fila
                        toRow = fromRow - 1;
                        toCol = fromCol;
                        movePiece = true;
                    }
                }
            }
        }

        moveAction.add(0, fromRow); //from_row
        moveAction.add(1, fromCol); //from_col
        moveAction.add(2, toRow); //to_row
        moveAction.add(3, toCol); //to_col

        return moveAction;
    }

    public void printBoard(String color, String board, String moveLeft, String username) {
        System.out.println("Turn - Username: " + username + " - Color: " + color + " - Move Left: " + moveLeft);
        System.out.println("R- C-0123456789112345-C  -R");
        int nroRow = 0;
        for (int i = 0; i < board.length(); i++) {
            if (i == 0) {
                System.out.print("0  | ");
            }
            System.out.print(board.charAt(i));
            if ((i == 15) || (i == 31) || (i == 47) || (i == 63) || (i == 79) || (i == 95)
                    || (i == 111) || (i == 127) || (i == 143) || (i == 159) || (i == 175)
                    || (i == 191) || (i == 207) || (i == 223) || (i == 239) || (i == 255)) {

                System.out.println(" | " + nroRow);
                nroRow = nroRow + 1;
                if (nroRow < 10) {
                    System.out.print(nroRow + "  | ");
                } else {
                    if (nroRow < 16) {
                        System.out.print(nroRow + " | ");
                    }
                }
            }
        }
        System.out.println("R- C-0123456789112345-C  -R");
        System.out.println("------------------------------------------------");
    }

}
