package com.example.BlueringProject.Controller;

import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BlueringProject.Mapper.EmployeeMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/bluering/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

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
    public ResponseEntity<String> createEmployee(@RequestBody Map<String, Object> employeeDetails) throws IllegalAccessException {
        employeeService.createEntity(employeeDetails);
        return ResponseEntity.ok("Employee informations successfully created");
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity != null) {
            EmployeeDTO employeeDTO = employeeMapper.toDto(employeeEntity);
            return ResponseEntity.ok(employeeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<EmployeeDTO> getAllEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity != null) {
            EmployeeDTO employeeDTO = employeeMapper.toDto(employeeEntity);
            return ResponseEntity.ok(employeeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        employeeService.updateEntity(id, employeeDetails);
        return ResponseEntity.ok("Employee successfully updated");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws IllegalAccessException {
        employeeService.deleteEntity(id);
        return ResponseEntity.ok("Employee successfully deleted");
    }
}

