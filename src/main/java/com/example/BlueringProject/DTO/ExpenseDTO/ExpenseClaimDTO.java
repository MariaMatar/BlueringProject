package com.example.BlueringProject.DTO.ExpenseDTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ExpenseClaimDTO {
    private int ExpenseClaimId;
    private LocalDate ExpenseClaimDate;
    private String ExpenseClaimDescription;
    private int ExpenseClaimTotal;
    private String ExpenseClaimStatus;
    private int ExpenseClaimEmployeeId;

    public Integer getTotal() {
        return null;
    }

    public String getDescription() {
        return null;
    }

//    public ExpenseClaimEntryDTO[] getEntries() {
//        return null;
//    }
}
