package pl.gontarczyk.pawnmovegame.model.pawn.move;

import lombok.*;
import pl.gontarczyk.pawnmovegame.common.Movement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PawnMovement {

    private Movement direction;
}