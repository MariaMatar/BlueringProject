package com.example.BlueringProject.Repositories;

import com.example.BlueringProject.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {


    @Query("SELECT e FROM EmployeeEntity e WHERE e.id = :id AND e.firstName = :firstName AND e.lastName = :lastName")
    List<EmployeeEntity> getEmployeesBy(@Param("id") int id, @Param("firstName") String firstName, @Param("lastName") String lastName);
    @Query("SELECT e FROM EmployeeEntity e WHERE e.id = ?1 AND e.firstName = ?2 AND e.lastName = ?3")
    EmployeeEntity getEmployeeById(int id , String firstName, String lastName);

    EmployeeEntity findEmployeeByIdAndFirstNameAndLastNameIsNotNull(int id, String firstName);

}
