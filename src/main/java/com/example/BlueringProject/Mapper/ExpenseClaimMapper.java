package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.BlueringProject.Entities.ExpenseClaimEntityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseClaimMapper {
    ExpenseClaimMapper INSTANCE = Mappers.getMapper(ExpenseClaimMapper.class);

    ExpenseClaimDTO ExpenseClaimEntityToExpenseClaimDTO(ExpenseClaimEntityEntity expenseClaimEntity);

    ExpenseClaimEntityEntity ExpenseClaimDTOToExpenseClaimEntity(ExpenseClaimDTO expenseClaimDTO);
}
