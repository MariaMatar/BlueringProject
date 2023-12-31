package com.example.BlueringProject.Repositories;

import com.example.BlueringProject.Entities.DepartmentEntity;
import com.example.BlueringProject.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByDepartmentId(Integer departmentId);
}