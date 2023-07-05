package com.example.BlueringProject.Entities.ExpensesClaims;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "ExpenseClaim_entity", schema = "internship", catalog = "")
public class ExpenseClaimEntryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ExpenseClaimEntryId")
    private Integer id;
    @Basic
    @Column(name = "ExpenseClaimEntryDate")
    private LocalDate expenseClaimDate;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "ExpenseClaimEntryTotal")
    private Integer ExpenseClaimTotal;
    @Basic
    @Column(name = "ExpenseClaimId")
    private Integer expenseClaimId;
    @Basic
    @Column(name = "ExpenseTypeId")
    private Integer expenseTypeId;

    public void setDate(LocalDate entryDate) {
    }

    public void setExpenseType(String entryType) {
    }

    public void setExpenseClaim(ExpenseClaimEntity expenseClaim) {
    }

    public String getExpenseType() {
        return null;
    }

    public BigDecimal getTotalAmount() {
        return null;
    }

    public void setTotal(LocalDate totalAmount) {
    }

    public BigDecimal getTotal() {
        return null;
    }
}