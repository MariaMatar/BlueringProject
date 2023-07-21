package com.example.BlueringProject.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "expense_type_entity", schema = "internship", catalog = "")


public class ExpenseTypeEntityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "expense_type_id")
    private int expenseTypeId;
    @Basic
    @Column(name = "expense_type_name")
    private String expenseTypeName;

    @Override
    public String toString() {
        return "ExpenseTypeEntityEntity{" +
                "expenseTypeId=" + expenseTypeId +
                ", expenseTypeName='" + expenseTypeName + '\'' +
                '}';
    }
}
