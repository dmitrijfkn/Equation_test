package com.tsidylo.practice.controller;

import com.tsidylo.practice.entity.Solution;
import com.tsidylo.practice.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solutions")
public class SolutionController {

    private final SolutionService solutionService;

    @Autowired
    private SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/all")
    public String getAllSolutions(Model model) {

        model.addAttribute("solutions", solutionService.getAllSolutions());

        return "solutions";
    }

    @GetMapping("/{id}")
    public String getSolution(@PathVariable Long id, Model model) {
        Solution solution = solutionService.getById(id);

        model.addAttribute("solution", solution);
        model.addAttribute("equations", solution.getEquations());

        return "solution";
    }
}
