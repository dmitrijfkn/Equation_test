package com.tsidylo.practice.repository;

import com.tsidylo.practice.entity.Equation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquationRepository extends JpaRepository<Equation, Long> {
    boolean existsByEquation(String equation);

    List<Equation> findAllByOrderByIdAsc();
}
