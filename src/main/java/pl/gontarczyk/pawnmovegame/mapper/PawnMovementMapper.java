package pl.gontarczyk.pawnmovegame.mapper;

import org.mapstruct.*;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovementDto;

@Mapper
public interface PawnMovementMapper {

    @Mapping(source = "direction", target = "direction")
    PawnMovement mapFromDto(PawnMovementDto pawnMovementDto);
}