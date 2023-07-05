package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseTypeEntity;
import org.springframework.http.ResponseEntity;

public interface ExpenseTypeService {

    ExpenseTypeDTO create(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO update(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO get(int id);

    ExpenseTypeDTO delete(int id);

    ResponseEntity<ExpenseTypeEntity> deleteEntity(int id) throws IllegalAccessException;


    ExpenseTypeEntity createExpenseType(ExpenseTypeEntity expenseType);
}
