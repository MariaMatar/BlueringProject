package com.example.BlueringProject.Services;

import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    static void deleteById(Long idValue) {
    }

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    EmployeeDTO get(int id);

    EmployeeDTO delete(int id);

    List<EmployeeDTO> getAll();

    ResponseEntity<EmployeeEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<EmployeeEntity> getEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> getAllEntity(int id, Map<String, Object> employeeDTO);

    ResponseEntity<EmployeeEntity> updateEntity(int id, Map<String, Object> employeeDTO);


    ResponseEntity<EmployeeEntity> createEntity(Map<String, Object> employeeDTO) throws IllegalAccessException;

}


