package pl.gontarczyk.pawnmovegame.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gontarczyk.pawnmovegame.model.board.Board;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

@Configuration
@RequiredArgsConstructor
public class GameConfiguration {

    @Bean
    public Board board() {
        return Board.builder()
                .maxCol(4)
                .maxRow(4)
                .build();
    }

    @Bean
    public Pawn pawn() {
        Position position = Position.builder()
                .x(0)
                .y(0)
                .build();

        return Pawn.builder()
                .currentPosition(position)
                .positions(new ArrayList<>())
                .build();
    }

    @Bean
    public void putPawnOnBoard() {
        Board board = board();
        Pawn pawn = pawn();
        board.setPawn(pawn);
    }
}