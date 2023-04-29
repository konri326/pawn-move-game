package pl.gontarczyk.pawnmovegame.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionDto {

    private final LocalDateTime dateTime = LocalDateTime.now();
    private final String message;
}