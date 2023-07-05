package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseClaimMapper {
    ExpenseClaimMapper INSTANCE = Mappers.getMapper(ExpenseClaimMapper.class);

    ExpenseClaimDTO ExpenseClaimEntityToExpenseClaimDTO(ExpenseClaimEntity expenseClaimEntity);

    ExpenseClaimEntity ExpenseClaimDTOToExpenseClaimEntity(ExpenseClaimDTO expenseClaimDTO);
}
