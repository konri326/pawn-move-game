package pl.gontarczyk.pawnmovegame.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Movement {
    UP (new Position(0, 1)),
    DOWN (new Position(0, -1)),
    LEFT (new Position(-1, 0)),
    RIGHT (new Position(1, 0));

    private final Position position;

    public static boolean isDirection(String stringMovement) {
        return Arrays.stream(Movement.values())
                .anyMatch(movement -> movement.name().equals(stringMovement));
    }
}