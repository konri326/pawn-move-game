package pl.gontarczyk.pawnmovegame.model.pawn;

import lombok.*;
import pl.gontarczyk.pawnmovegame.model.position.Position;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PawnDto {

    private Position currentPosition;
}