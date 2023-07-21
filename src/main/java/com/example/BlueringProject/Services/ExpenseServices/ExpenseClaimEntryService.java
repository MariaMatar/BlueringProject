package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public interface ExpenseClaimEntryService {

    ExpenseClaimEntryDTO create(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO update(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO get(int id);

    ExpenseClaimEntryDTO delete(int id);

    List<ExpenseClaimEntryDTO> getExpenseClaimEntriesByClaimId(Integer expenseClaimId);

    ResponseEntity<ExpenseTypeEntityEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<ExpenseClaimEntryDTO> getEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseClaimEntryDTO> getAllEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseTypeEntityEntity> updateEntity(int id, Map<String, Object> expenseClaimEntryDTO);
}
