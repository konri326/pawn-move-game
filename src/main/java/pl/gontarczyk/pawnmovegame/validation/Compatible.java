package pl.gontarczyk.pawnmovegame.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CompatibleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Compatible {

    String message() default "Invalid Direction.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}