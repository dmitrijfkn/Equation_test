package com.tsidylo.practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Solution {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Double solution;

    @ManyToMany(mappedBy = "solutions")
    private Set<Equation> equations;
}