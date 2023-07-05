package com.example.BlueringProject.Entities;

import jakarta.persistence.*;

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

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }

    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseTypeEntityEntity that = (ExpenseTypeEntityEntity) o;

        if (expenseTypeId != that.expenseTypeId) return false;
        if (expenseTypeName != null ? !expenseTypeName.equals(that.expenseTypeName) : that.expenseTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseTypeId;
        result = 31 * result + (expenseTypeName != null ? expenseTypeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseTypeEntityEntity{" +
                "expenseTypeId=" + expenseTypeId +
                ", expenseTypeName='" + expenseTypeName + '\'' +
                '}';
    }
}
