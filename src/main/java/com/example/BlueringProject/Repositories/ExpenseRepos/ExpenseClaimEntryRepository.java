package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntity;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseClaimEntryEntity, Long> {
    List<ExpenseClaimEntryEntity> findByExpenseClaimEntity(ExpenseClaimEntity expenseClaimEntity);
}