package pl.gontarczyk.pawnmovegame.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import pl.gontarczyk.pawnmovegame.common.Movement;

@RequiredArgsConstructor
public class CompatibleValidator implements ConstraintValidator<Compatible, String> {

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Movement.isDirection(s);
    }
}