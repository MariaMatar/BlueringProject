package com.example.BlueringProject.Entities.ExpensesClaims;

import com.example.BlueringProject.Entities.EmployeeEntity;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "ExpenseClaim_entity", schema = "internship", catalog = "")
public class ExpenseClaimEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ExpenseClaimId")
    private Integer claimId;
    @Basic
    @Column(name = "ExpenseClaimDate")
    private LocalDate expenseClaimDate;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "ExpenseClaimTotal")
    private Integer ExpenseClaimTotal;
    @Basic
    @Column(name = "ExpenseClaimStatus")
    private String expenseClaimStatus;
    @Basic
    @Column(name = "EmployeeId")
    private Integer employeeId;

}