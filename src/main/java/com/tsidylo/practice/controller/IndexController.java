package com.tsidylo.practice.controller;

import com.tsidylo.practice.form.EquationForm;
import com.tsidylo.practice.service.EquationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class IndexController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    private final EquationService equationService;

    @Autowired
    public IndexController(EquationService equationService) {
        this.equationService = equationService;
    }

    @GetMapping("/")
    public String mainForm(EquationForm equationForm) {
        return "index";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid EquationForm equationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            equationService.saveNewEquation(equationForm.getEquation());

            return "redirect:/result";
        }
    }

}