package com.example.BlueringProject.DTO.ExpenseDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseClaimEntryDTO {
    private LocalDate entryDate;
    private int entryId;
    private String entryType;
    private String entryDescription;
    private int ExpenseClaimId;
    private int ExpenseTypeId;
    private String expenseType;
    private Double total;

//    public LocalDate getTotalAmount() {
//        return null;
//    }
}
