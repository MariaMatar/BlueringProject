package com.example.BlueringProject.Entities.ExpensesClaims;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ExpenseTypeEntity", schema = "internship", catalog = "")
public class ExpenseTypeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ExpenseTypeId")
    private Integer id;
    @Basic
    @Column(name = "ExpenseTypeName")
    private String expenseTypeName;
    
}