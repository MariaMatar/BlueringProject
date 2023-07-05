package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntryEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ExpenseClaimEntryService {

    ExpenseClaimEntryDTO create(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO update(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO get(int id);

    ExpenseClaimEntryDTO delete(int id);

    ResponseEntity<ExpenseClaimEntryEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<ExpenseClaimEntryDTO> getEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseClaimEntryDTO> getAllEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseClaimEntryEntity> updateEntity(int id, Map<String, Object> expenseClaimEntryDTO);


}
