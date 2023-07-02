package com.example.BlueringProject.Controller;

import com.example.BlueringProject.ApiResponse;
import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.DepartmentRepository;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.Services.EmployeeServices.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@Data
@RestController
@RequestMapping("/bluering/api/v1/employees")

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;
    private DepartmentRepository departmentRepository;
    private ApiResponse response;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/all")
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {

        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public ApiResponse createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeDTO.getName());
        response.setMessage("Employee information CREATED successfully");
        return (response);
    }


    @PatchMapping("/{id}")
    public ApiResponse updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        employeeService.updateEntity(id, employeeDetails);
        ApiResponse response = new ApiResponse();
        response.setMessage("Employee information UPDATED successfully");
        return (response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws IllegalAccessException {
        employeeService.deleteEntity(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Employee information DELETED successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }


    //List Employees by Department
    @GetMapping("/departments/{departmentId}/employees")
    public List<EmployeeEntity> getEmployeesByDepartment(@PathVariable Integer departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }
}


