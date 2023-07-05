package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeEntity, Long> {


}
