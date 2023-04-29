package pl.gontarczyk.pawnmovegame.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovementDto;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = { PawnMovementMapperImpl.class })
class PawnMovementMapperTest {

    @Autowired
    private PawnMovementMapper pawnMovementMapper;

    @Test
    void testMapFromDto_shouldMapPawnMovementDtoToPawnMovement() {
        PawnMovementDto pawnMovementDto = PawnMovementDto.builder()
                .direction("UP")
                .build();

        PawnMovement pawnMovement = pawnMovementMapper.mapFromDto(pawnMovementDto);

        assertEquals(pawnMovement.getDirection().name(), pawnMovementDto.getDirection());
    }
}