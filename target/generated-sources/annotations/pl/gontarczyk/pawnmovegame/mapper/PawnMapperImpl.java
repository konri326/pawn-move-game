package pl.gontarczyk.pawnmovegame.mapper;

import javax.annotation.processing.Generated;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.pawn.PawnDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T17:51:02+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class PawnMapperImpl implements PawnMapper {

    @Override
    public PawnDto mapToDto(Pawn pawn) {
        if ( pawn == null ) {
            return null;
        }

        PawnDto.PawnDtoBuilder pawnDto = PawnDto.builder();

        pawnDto.currentPosition( pawn.getCurrentPosition() );

        return pawnDto.build();
    }
}
