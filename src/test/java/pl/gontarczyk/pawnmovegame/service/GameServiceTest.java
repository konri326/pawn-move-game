package pl.gontarczyk.pawnmovegame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.gontarczyk.pawnmovegame.common.Movement;
import pl.gontarczyk.pawnmovegame.exception.BoardFrameException;
import pl.gontarczyk.pawnmovegame.model.board.Board;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Spy
    private final Board board = Board.builder()
            .maxCol(2)
            .maxRow(2)
            .pawn(Pawn.builder()
                    .currentPosition(Position.builder()
                            .x(0)
                            .y(0)
                            .build())
                    .positions(new ArrayList<>())
                    .build())
            .build();

    @Mock
    private GifService gifService;

    @InjectMocks
    private GameService gameService;

    @Test
    void getPawnPosition_shouldReturnPawnWithCorrectPosition() {
        Pawn pawn = gameService.getPawnPosition();

        assertEquals(pawn.getCurrentPosition().getX(), board.getPawn().getCurrentPosition().getX());
        assertEquals(pawn.getCurrentPosition().getY(), board.getPawn().getCurrentPosition().getY());
    }

    @Test
    void testMovePawn_PawnShouldChangePosition() {
        PawnMovement pawnMovement = PawnMovement.builder()
                .direction(Movement.UP)
                .build();

        Pawn returnedPawn = gameService.movePawn(pawnMovement);

        assertEquals(returnedPawn.getCurrentPosition().getX(), 0);
        assertEquals(returnedPawn.getCurrentPosition().getY(), 1);
    }

    @Test
    void testMovePawn_ShouldThrowBoardFrameExceptionWhenPawnWantGoOutsideArea() {
        String exceptionMsg = "You can't go outside the board area!";
        PawnMovement pawnMovement = PawnMovement.builder()
                .direction(Movement.DOWN)
                .build();

        BoardFrameException exception = assertThrows(
                BoardFrameException.class,
                () -> gameService.movePawn(pawnMovement)
        );
        assertEquals(exception.getMessage(), exceptionMsg);
    }
}