package pl.gontarczyk.pawnmovegame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gontarczyk.pawnmovegame.mapper.PawnMapper;
import pl.gontarczyk.pawnmovegame.mapper.PawnMapperImpl;
import pl.gontarczyk.pawnmovegame.mapper.PawnMovementMapper;
import pl.gontarczyk.pawnmovegame.mapper.PawnMovementMapperImpl;

@Configuration
public class MapStructConfiguration {

    @Bean
    public PawnMapper pawnMapper() {
        return new PawnMapperImpl();
    }

    @Bean
    public PawnMovementMapper pawnMovementMapper() {
        return new PawnMovementMapperImpl();
    }
}