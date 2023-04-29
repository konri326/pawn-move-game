package pl.gontarczyk.pawnmovegame.mapper;

import javax.annotation.processing.Generated;
import pl.gontarczyk.pawnmovegame.common.Movement;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovementDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T17:51:02+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class PawnMovementMapperImpl implements PawnMovementMapper {

    @Override
    public PawnMovement mapFromDto(PawnMovementDto pawnMovementDto) {
        if ( pawnMovementDto == null ) {
            return null;
        }

        PawnMovement.PawnMovementBuilder pawnMovement = PawnMovement.builder();

        if ( pawnMovementDto.getDirection() != null ) {
            pawnMovement.direction( Enum.valueOf( Movement.class, pawnMovementDto.getDirection() ) );
        }

        return pawnMovement.build();
    }
}
