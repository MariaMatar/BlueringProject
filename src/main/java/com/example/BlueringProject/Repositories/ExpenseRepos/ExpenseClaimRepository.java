package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpenseClaimEntityEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;
import java.util.List;


public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaimEntityEntity, Long> {
    
//    List<ExpenseClaimEntityEntity> findByEmployeeId(Long employeeId);

//    List<ExpenseClaimEntityEntity> findByExpenseClaimId(SingularAttribute<AbstractPersistable, Serializable> id);
}