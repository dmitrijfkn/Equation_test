package com.tsidylo.practice.service;

import com.tsidylo.practice.entity.Equation;
import com.tsidylo.practice.entity.Solution;
import com.tsidylo.practice.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class SolutionService {

    private final SolutionRepository solutionRepository;

    @Autowired
    SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }


    public List<Solution> getAllSolutions() {
        return solutionRepository.findAllByOrderBySolutionAsc();
    }

    public void saveSolution(Double solution, Equation equation) {
        Solution solution1;
        if (solutionRepository.existsBySolution(solution)) {
            solution1 = solutionRepository.findBySolution(solution);
        } else {
            solution1 = new Solution();
            solution1.setSolution(solution);
        }

        if (solution1.getEquations() == null) {
            solution1.setEquations(new HashSet<>());
        }
        solution1.getEquations().add(equation);

        solutionRepository.save(solution1);

        equation.getSolutions().add(solution1);

    }

    public Solution getById(Long id) {
        return solutionRepository.getReferenceById(id);
    }
}
