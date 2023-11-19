package com.tsidylo.practice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketsValidator implements ConstraintValidator<BracketsCorrect, String> {

    public boolean areBracketsBalanced(String equation) {
        String pattern = "\\([^()]*\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(equation);

        while (matcher.find()) {
            equation = equation.replace(matcher.group(), "");
            matcher = regex.matcher(equation);
        }

        return equation.isEmpty();
    }


    @Override
    public boolean isValid(String equation, ConstraintValidatorContext context) {
        if (equation.contains("=") &&
                equation.indexOf("=") != equation.length() - 1 &&
                equation.indexOf("=") == equation.lastIndexOf("=")
        ) {
            String leftPart = equation.substring(0, equation.indexOf("="));
            String rightPart = equation.substring(equation.indexOf("=") + 1);

            leftPart= leftPart.replaceAll("[^()]","");
            rightPart= rightPart.replaceAll("[^()]","");

            return areBracketsBalanced(leftPart) && areBracketsBalanced(rightPart);
        }

        return false;
    }
}