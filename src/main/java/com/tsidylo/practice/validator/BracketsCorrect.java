package com.tsidylo.practice.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BracketsValidator.class)
@Documented
public @interface BracketsCorrect {
    String message() default "Parentheses are placed incorrectly";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}