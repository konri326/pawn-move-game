package pl.gontarczyk.pawnmovegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PawnMoveGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(PawnMoveGameApplication.class, args);
    }
}