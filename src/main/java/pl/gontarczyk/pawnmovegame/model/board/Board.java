package pl.gontarczyk.pawnmovegame.model.board;

import lombok.*;
import pl.gontarczyk.pawnmovegame.exception.BoardFrameException;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.position.Position;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Board {

    private final int minCol = 0;
    private final int minRow = 0;
    private int maxCol;
    private int maxRow;
    private Pawn pawn;

    public synchronized void updatePawnPosition(Position position) {
        if (isBehindBoardArea(position)) {
            throw new BoardFrameException();
        }
        pawn.getCurrentPosition().setX(pawn.getCurrentPosition().getX() + position.getX());
        pawn.getCurrentPosition().setY(pawn.getCurrentPosition().getY() + position.getY());
        pawn.addPositionToList(pawn.getCurrentPosition());
    }

    public boolean isBehindBoardArea(Position position) {
        Position newPosition = new Position(0, 0);
        newPosition.setX(pawn.getCurrentPosition().getX() + position.getX());
        newPosition.setY(pawn.getCurrentPosition().getY() + position.getY());
        if (newPosition.getX() < minRow || newPosition.getX() > maxRow) {
            return true;
        } else {
            return newPosition.getY() < minCol || newPosition.getY() > maxCol;
        }
    }
}