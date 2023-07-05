package com.example.BlueringProject.Repositories.ExpenseRepos;

import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;
import java.util.List;


public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaimEntity, Long> {
    List<ExpenseClaimEntity> findByEmployeeId(Long employeeId);

    List<ExpenseClaimEntity> findById(SingularAttribute<AbstractPersistable, Serializable> id);
}