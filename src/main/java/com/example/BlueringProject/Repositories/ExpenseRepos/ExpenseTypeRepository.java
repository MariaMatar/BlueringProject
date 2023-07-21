package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeEntityEntity, Long> {


}
