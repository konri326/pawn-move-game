package pl.gontarczyk.pawnmovegame.mapper;

import org.mapstruct.Mapper;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.pawn.PawnDto;

@Mapper
public interface PawnMapper {

    PawnDto mapToDto(Pawn pawn);
}