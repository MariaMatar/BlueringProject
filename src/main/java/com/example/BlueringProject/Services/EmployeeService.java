package com.example.BlueringProject.Services;

import com.example.BlueringProject.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);
    
    EmployeeDTO get(int id);
    EmployeeDTO delete(int id);

    List<EmployeeDTO> getAll();
}
