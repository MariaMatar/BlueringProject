package com.example.BlueringProject.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "expense_claim_entity", schema = "internship", catalog = "")
public class ExpenseClaimEntityEntity {
    @Basic
    @Column(name = "expense_claim_id")
    private int expenseClaimId;
    @Basic
    @Column(name = "expense_claim_total")
    private Integer expenseClaimTotal;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic
    @Column(name = "expense_claim_date")
    private Date expenseClaimDate;
    @Basic
    @Column(name = "expense_claim_status")
    private String expenseClaimStatus;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "expense_claim_entry_id")
    private int expenseClaimEntryId;
    @Basic
    @Column(name = "expense_claim_entry_total")
    private Integer expenseClaimEntryTotal;
    @Basic
    @Column(name = "expense_claim_entry_date")
    private Date expenseClaimEntryDate;
    @Basic
    @Column(name = "expense_type_id")
    private Integer expenseTypeId;

    public int getExpenseClaimId() {
        return expenseClaimId;
    }

    public void setExpenseClaimId(int expenseClaimId) {
        this.expenseClaimId = expenseClaimId;
    }

    public Integer getExpenseClaimTotal() {
        return expenseClaimTotal;
    }

    public void setExpenseClaimTotal(Integer expenseClaimTotal) {
        this.expenseClaimTotal = expenseClaimTotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getExpenseClaimDate() {
        return expenseClaimDate;
    }

    public void setExpenseClaimDate(Date expenseClaimDate) {
        this.expenseClaimDate = expenseClaimDate;
    }

    public String getExpenseClaimStatus() {
        return expenseClaimStatus;
    }

    public void setExpenseClaimStatus(String expenseClaimStatus) {
        this.expenseClaimStatus = expenseClaimStatus;
    }

    public int getExpenseClaimEntryId() {
        return expenseClaimEntryId;
    }

    public void setExpenseClaimEntryId(int expenseClaimEntryId) {
        this.expenseClaimEntryId = expenseClaimEntryId;
    }

    public Integer getExpenseClaimEntryTotal() {
        return expenseClaimEntryTotal;
    }

    public void setExpenseClaimEntryTotal(Integer expenseClaimEntryTotal) {
        this.expenseClaimEntryTotal = expenseClaimEntryTotal;
    }

    public Date getExpenseClaimEntryDate() {
        return expenseClaimEntryDate;
    }

    public void setExpenseClaimEntryDate(Date expenseClaimEntryDate) {
        this.expenseClaimEntryDate = expenseClaimEntryDate;
    }

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseClaimEntityEntity that = (ExpenseClaimEntityEntity) o;

        if (expenseClaimId != that.expenseClaimId) return false;
        if (expenseClaimEntryId != that.expenseClaimEntryId) return false;
        if (expenseClaimTotal != null ? !expenseClaimTotal.equals(that.expenseClaimTotal) : that.expenseClaimTotal != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (expenseClaimDate != null ? !expenseClaimDate.equals(that.expenseClaimDate) : that.expenseClaimDate != null)
            return false;
        if (expenseClaimStatus != null ? !expenseClaimStatus.equals(that.expenseClaimStatus) : that.expenseClaimStatus != null)
            return false;
        if (expenseClaimEntryTotal != null ? !expenseClaimEntryTotal.equals(that.expenseClaimEntryTotal) : that.expenseClaimEntryTotal != null)
            return false;
        if (expenseClaimEntryDate != null ? !expenseClaimEntryDate.equals(that.expenseClaimEntryDate) : that.expenseClaimEntryDate != null)
            return false;
        if (expenseTypeId != null ? !expenseTypeId.equals(that.expenseTypeId) : that.expenseTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseClaimId;
        result = 31 * result + (expenseClaimTotal != null ? expenseClaimTotal.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (expenseClaimDate != null ? expenseClaimDate.hashCode() : 0);
        result = 31 * result + (expenseClaimStatus != null ? expenseClaimStatus.hashCode() : 0);
        result = 31 * result + expenseClaimEntryId;
        result = 31 * result + (expenseClaimEntryTotal != null ? expenseClaimEntryTotal.hashCode() : 0);
        result = 31 * result + (expenseClaimEntryDate != null ? expenseClaimEntryDate.hashCode() : 0);
        result = 31 * result + (expenseTypeId != null ? expenseTypeId.hashCode() : 0);
        return result;
    }
}
