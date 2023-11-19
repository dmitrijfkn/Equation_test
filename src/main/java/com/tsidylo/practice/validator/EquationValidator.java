package com.tsidylo.practice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationValidator implements ConstraintValidator<IsEquation, String> {

    public boolean containsIncorrectSymbols(String inputString) {
        Pattern pattern = Pattern.compile("[+\\-/*][)]|[(][+/*]|[+-/*][+*/]|[+-/*]{2,}[^0-9]|-[)]|[^0-9()x\\-+/*.,]|[^0-9]+[.,]|[.,][^0-9]+|[.,]$");

        Matcher matcher = pattern.matcher(inputString);

        return matcher.find();
    }


    @Override
    public boolean isValid(String equation, ConstraintValidatorContext context) {
        if (equation.contains("=") &&
                equation.indexOf("=") != equation.length() - 1 &&
                equation.indexOf("=") == equation.lastIndexOf("=")
        ) {
            String leftPart = equation.substring(0, equation.indexOf("="));
            String rightPart = equation.substring(equation.indexOf("=") + 1);

            return !containsIncorrectSymbols(leftPart) && !containsIncorrectSymbols(rightPart);
        }

        return false;
    }
}