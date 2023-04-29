package pl.gontarczyk.pawnmovegame.exception;

public class BoardFrameException extends RuntimeException {

    public BoardFrameException() {
        super("You can't go outside the board area!");
    }
}
