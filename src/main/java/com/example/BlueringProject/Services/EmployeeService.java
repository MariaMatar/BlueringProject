package com.example.BlueringProject.Services;

import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    EmployeeDTO get(int id);

    EmployeeDTO delete(int id);

    List<EmployeeDTO> getAll();

    ResponseEntity<EmployeeEntity> getEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> getAllEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> updateEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> deleteEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> createEntity(int id, Map<String, Object> employeeDTO);


}


