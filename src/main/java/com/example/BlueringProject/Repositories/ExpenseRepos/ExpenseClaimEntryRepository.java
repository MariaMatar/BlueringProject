package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpenseClaimEntityEntity;
import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseTypeEntityEntity, Long> {
    List<ExpenseTypeEntityEntity> findByExpenseClaimEntity(ExpenseClaimEntityEntity expenseClaimEntity);
}
