package com.tsidylo.practice.controller;

import com.tsidylo.practice.entity.Equation;
import com.tsidylo.practice.form.SolutionForm;
import com.tsidylo.practice.service.EquationService;
import com.tsidylo.practice.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equations")
public class EquationController {

    private final EquationService equationService;
    private final SolutionService solutionService;

    @Autowired
    private EquationController(EquationService equationService, SolutionService solutionService) {
        this.equationService = equationService;
        this.solutionService = solutionService;
    }

    @GetMapping("/all")
    public String getAllEquations(Model model) {

        model.addAttribute("equations", equationService.getAllEquations());

        return "equations";
    }

    @GetMapping("/{id}")
    public String getEquation(@PathVariable Long id, Model model) {
        Equation equation = equationService.getById(id);

        model.addAttribute("equation", equation);
        model.addAttribute("solutionForm", new SolutionForm());
        model.addAttribute("solutions", equation.getSolutions());

        return "equation";
    }


    @PostMapping("/checkSolution")
    public String checkPersonInfo(SolutionForm solutionForm, Long equationId, Model model) {

        if (solutionForm == null || solutionForm.getSolution() == null) {
            model.addAttribute("error", "Solution can't be null");
        } else if (!equationService.isSolutionCorrect(solutionForm.getSolution(), equationId)) {
            model.addAttribute("error", "This solution is incorrect");
        } else {
            model.addAttribute("success", "Solution is correct");
        }
        return getEquation(equationId, model);
    }
}
