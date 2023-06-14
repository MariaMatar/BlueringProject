package com.example.BlueringProject.Controller;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @CrossOrigin("*")
    @RestController
    @RequestMapping("/bluering/api/v1/employees")
    public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepository;

        @GetMapping
        public List <EmployeeEntity> getAllEmployees() {
            return employeeRepository.findAll();
        }

        // build create employee Rest Api
        @PostMapping
        public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee){
            return employeeRepository.save(employee);
        }

        // build get employee by id Rest Api
        @GetMapping("/{id}")
        public ResponseEntity<EmployeeEntity> getEmployeeById( @PathVariable long id){
            EmployeeEntity employee = employeeRepository.findById((int) id)
                    .orElseThrow();
            return ResponseEntity.ok(employee);
        }

        // build update employee Rest Api
        @PutMapping("/{id}")
        public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable long id, @RequestBody EmployeeEntity employeeDetails) {
            EmployeeEntity employee = employeeRepository.findById((int) id)
                    .orElseThrow();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber());
            EmployeeEntity updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        }

        //build delete employee Rest Api
        @DeleteMapping("/{id}")
        public ResponseEntity <EmployeeEntity> deleteEmployee(@PathVariable long id){
            EmployeeEntity employee = employeeRepository.findById((int) id)
                    .orElseThrow();
            employeeRepository.delete(employee);
            return new ResponseEntity <> (HttpStatus.NO_CONTENT);
        }

    //build delete all employees Rest Api
    @DeleteMapping
    public ResponseEntity <EmployeeEntity> deleteAllEmployees() {
        employeeRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

