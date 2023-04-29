package pl.gontarczyk.pawnmovegame.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.gontarczyk.pawnmovegame.model.pawn.Pawn;
import pl.gontarczyk.pawnmovegame.model.pawn.PawnDto;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(classes = { PawnMapperImpl.class })
class PawnMapperTest {

    @Autowired
    private PawnMapper pawnMapper;

    @Test
    void testMapToDto_shouldMapPawnToPawnDto() {
        Pawn pawn = Pawn.builder()
                .currentPosition(Position.builder()
                        .x(0)
                        .y(0)
                        .build())
                .build();

        PawnDto pawnDto = pawnMapper.mapToDto(pawn);

        assertEquals(pawnDto.getCurrentPosition().getX(), pawn.getCurrentPosition().getX());
        assertEquals(pawnDto.getCurrentPosition().getY(), pawn.getCurrentPosition().getX());
    }
}