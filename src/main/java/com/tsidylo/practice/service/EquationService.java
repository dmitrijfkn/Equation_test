package com.tsidylo.practice.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.tsidylo.practice.entity.Equation;
import com.tsidylo.practice.repository.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquationService {

    private final EquationRepository equationRepository;

    private final SolutionService solutionService;

    @Autowired
    public EquationService(EquationRepository equationRepository, SolutionService solutionService) {
        this.equationRepository = equationRepository;
        this.solutionService = solutionService;
    }

    public void saveNewEquation(String line) {
        if (!equationRepository.existsByEquation(line)) {
            Equation equation = new Equation();
            equation.setEquation(line);

            equationRepository.save(equation);
        }
    }

    public List<Equation> getAllEquations() {
        return equationRepository.findAllByOrderByIdAsc();
    }

    public Equation getById(Long id) {
        return equationRepository.getReferenceById(id);
    }

    public boolean isSolutionCorrect(Double solution, Long equationId) {

        DoubleEvaluator doubleEvaluator = new DoubleEvaluator();

        Equation equation = getById(equationId);

        String leftPart = equation.getEquation().substring(0, equation.getEquation().indexOf('='));
        String rightPart = equation.getEquation().substring(equation.getEquation().indexOf('=') + 1);

        leftPart = leftPart.replaceAll("x", solution.toString());
        rightPart = rightPart.replaceAll("x", solution.toString());

        if (doubleEvaluator.evaluate(leftPart).equals(doubleEvaluator.evaluate(rightPart))) {

            solutionService.saveSolution(solution, equation);

            equationRepository.save(equation);

            return true;
        } else {
            return false;
        }
    }
}
