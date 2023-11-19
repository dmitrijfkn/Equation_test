package com.tsidylo.practice.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EquationValidator.class)
@Documented
public @interface IsEquation {
    String message() default "Entered text is not a valid equation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}