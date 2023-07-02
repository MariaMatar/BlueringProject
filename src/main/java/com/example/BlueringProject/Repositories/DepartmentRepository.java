package com.example.BlueringProject.Repositories;

import com.example.BlueringProject.Entities.DepartmentEntity;
import com.example.BlueringProject.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}