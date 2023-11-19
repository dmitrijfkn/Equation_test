package com.tsidylo.practice.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SolutionForm {
    @NotNull
    private Double solution;

    @Override
    public String toString() {
        return solution.toString();
    }
}
