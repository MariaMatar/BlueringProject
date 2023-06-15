package com.example.BlueringProject.Controller;


import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.Services.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/bluering/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {

        return employeeService.createEntity(id, employeeDetails);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        return employeeService.getEntity(id, employeeDetails);
    }

    @GetMapping
    public ResponseEntity<EmployeeEntity> getAllEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        return employeeService.getAllEntity(id, employeeDetails);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        return employeeService.updateEntity(id, employeeDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        return employeeService.deleteEntity(id, employeeDetails);
    }
}

