package pl.gontarczyk.pawnmovegame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.gontarczyk.pawnmovegame.exception.model.ExceptionDto;
import pl.gontarczyk.pawnmovegame.exception.model.ValidationExceptionDto;

@RestControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handlerArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationExceptionDto exceptionDto = new ValidationExceptionDto();
        e.getFieldErrors()
                .forEach(error -> exceptionDto.addErrorInfo(error.getField(), error.getDefaultMessage()));
        return exceptionDto;
    }

    @ExceptionHandler(BoardFrameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handlerArgumentNotValidException(BoardFrameException e) {
        return new ExceptionDto(e.getMessage());
    }
}