package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.BlueringProject.Entities.ExpenseClaimEntityEntity;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseClaimRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExpenseClaimService {
    void submitExpense(ExpenseClaimDTO expenseClaimDTO);

    Map<String, Map<String, Double>> getTotalClaimsPerTypePerEmployee();

    ExpenseClaimRepository expenseClaimRepository = null;
    Long employeeId = null;

    ExpenseClaimDTO create(ExpenseClaimDTO expenseClaimDTO);


    ExpenseClaimDTO update(ExpenseClaimDTO expenseClaimDTO);

    ExpenseClaimDTO get(int id);

    ExpenseClaimDTO delete(int id);

    ResponseEntity<ExpenseClaimEntityEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<ExpenseClaimDTO> getEntity(int id, Map<String, Object> expenseClaimDTO);

    ResponseEntity<ExpenseClaimDTO> getAllEntity(int id, Map<String, Object> expenseClaimDTO);

    ResponseEntity<ExpenseClaimEntityEntity> updateEntity(int id, Map<String, Object> expenseClaimDTO);

//    List<ExpenseClaimEntityEntity> expenseClaims = expenseClaimRepository.findByEmployeeId(employeeId);

    void saveExpenseClaimEntity(ExpenseClaimEntityEntity expenseClaim);

    List<ExpenseClaimEntityEntity> getAllExpenseClaims();
}

