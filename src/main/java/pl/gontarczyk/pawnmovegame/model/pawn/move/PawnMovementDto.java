package pl.gontarczyk.pawnmovegame.model.pawn.move;

import lombok.*;
import pl.gontarczyk.pawnmovegame.validation.Compatible;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PawnMovementDto {

    @Compatible
    private String direction;
}