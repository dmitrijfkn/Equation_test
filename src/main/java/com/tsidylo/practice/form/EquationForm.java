package com.tsidylo.practice.form;

import com.tsidylo.practice.validator.BracketsCorrect;
import com.tsidylo.practice.validator.IsEquation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EquationForm {
    @NotNull
    @Size(min = 3, max = 255, message = "Length of equation must be between 3 and 255 symbols")
    @IsEquation
    @BracketsCorrect
    private String equation;

    @Override
    public String toString() {
        return equation;
    }
}