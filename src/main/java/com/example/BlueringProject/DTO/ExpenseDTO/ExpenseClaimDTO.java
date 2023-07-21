package com.example.BlueringProject.DTO.ExpenseDTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ExpenseClaimDTO {
    private Integer ExpenseClaimId;
    private LocalDate ExpenseClaimDate;
    private String ExpenseClaimDescription;
    private Integer ExpenseClaimTotal;
    private String ExpenseClaimStatus;
    private Integer ExpenseClaimEmployeeId;

}
