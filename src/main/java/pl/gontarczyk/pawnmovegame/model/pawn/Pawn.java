package pl.gontarczyk.pawnmovegame.model.pawn;

import lombok.*;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Pawn {

    private Position currentPosition;
    private List<Position> positions;

    public void addPositionToList(Position position) {
        positions.add(Position.builder()
                .x(position.getX())
                .y(position.getY())
                .build());
    }
}