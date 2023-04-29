package pl.gontarczyk.pawnmovegame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gontarczyk.pawnmovegame.model.board.Board;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;

@Service
@RequiredArgsConstructor
public class GameService {

    private final Board board;

    public Pawn movePawn(PawnMovement pawnMovement) {
        board.updatePawnPosition(pawnMovement.getDirection().getPosition());
        return board.getPawn();
    }

    public Pawn getPawnPosition() {
        return board.getPawn();
    }
}