package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseTypeService {

    ExpenseTypeDTO create(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO update(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO get(int id);

    ExpenseTypeDTO delete(int id);

    ResponseEntity<ExpenseTypeEntityEntity> deleteEntity(int id) throws IllegalAccessException;


    ExpenseTypeEntityEntity createExpenseType(ExpenseTypeEntityEntity expenseType);

    String getExpenseTypeNameById(Long expenseTypeId);

    List<ExpenseTypeEntityEntity> getAllExpenseTypes();
}
