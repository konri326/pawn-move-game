package pl.gontarczyk.pawnmovegame.exception;

public class IllegalPositionOnBoard extends RuntimeException {

    public IllegalPositionOnBoard() {
        super("Invalid pawn position.");
    }
}