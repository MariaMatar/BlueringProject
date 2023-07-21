package com.example.BlueringProject.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "expense_claim_entry", schema = "internship", catalog = "")

public class ExpenseEntryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "entryId")
    private Integer entryId;

    @Basic
    @Column(name = "total")
    private Double expenseClaimEntryTotal;

    @Basic
    @Column(name = "entryDate")
    private Date entryDate;

    @Basic
    @Column(name = "entryDescription")
    private String entryDescription;

    @Basic
    @Column(name = "expense_type_id")
    private Integer expenseTypeId;

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }
}
