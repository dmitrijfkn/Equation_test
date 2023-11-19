package com.tsidylo.practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Equation {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String equation;

    @ManyToMany
    @OrderBy("solution")
    @JoinTable(name = "equation_solution",
            joinColumns = @JoinColumn(name = "equation_id"),
            inverseJoinColumns = @JoinColumn(name = "solution_id")
    )
    private Set<Solution> solutions;
}
