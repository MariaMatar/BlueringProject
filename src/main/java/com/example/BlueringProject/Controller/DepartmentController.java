//package com.example.BlueringProject.Controller;
//
//import com.example.BlueringProject.ApiResponse;
//import com.example.BlueringProject.DTO.DepartmentDTO;
//import com.example.BlueringProject.DTO.EmployeeDTO;
//import com.example.BlueringProject.Entities.DepartmentEntity;
//import com.example.BlueringProject.Entities.EmployeeEntity;
//import com.example.BlueringProject.Repositories.DepartmentRepository;
//import com.example.BlueringProject.Repositories.EmployeeRepository;
//import com.example.BlueringProject.Services.DepartmentServices.DepartmentService;
//import com.example.BlueringProject.Services.EmployeeServices.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/departments")
//
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    private DepartmentService departmentService;
//
//    public DepartmentController(DepartmentService departmentService) {
//        this.departmentService = departmentService;
//    }
//
//    @PostMapping
//    public ApiResponse createDepartment(@RequestBody Map<String, Object> department) throws IllegalAccessException {
//        departmentService.createEntity(department);
//        ApiResponse response = new ApiResponse();
//        response.setMessage("Department informations CREATED successfully");
//        return response;
//    }
//
//
//    @GetMapping("/all")
//    public List<DepartmentEntity> getDepartments() {
//        return departmentRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Long id) {
//        DepartmentEntity department = departmentService.findDepartmentById(id);
//        if (department == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(department, HttpStatus.OK);
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<ApiResponse> updateDepartment(@PathVariable int id, @RequestBody Map<String, Object> departmentDetails) {
//        departmentService.updateEntity(id, departmentDetails);
//        ApiResponse response = new ApiResponse();
//        response.setMessage("Department information UPDATED successfully");
//        return ResponseEntity.ok(response);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ApiResponse deleteDepartment(@PathVariable int id) throws IllegalAccessException {
//        departmentService.deleteEntity(id);
//        ApiResponse response = new ApiResponse();
//        response.setMessage("Department information DELETED successfully");
//        return response;
//    }
//}

package com.example.BlueringProject.Controller;

import com.example.BlueringProject.ApiResponse;
import com.example.BlueringProject.DTO.DepartmentDTO;
import com.example.BlueringProject.Entities.DepartmentEntity;
import com.example.BlueringProject.Repositories.DepartmentRepository;
import com.example.BlueringProject.Services.DepartmentServices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final DepartmentService departmentService;
    private ApiResponse response;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments/create")
    public ApiResponse createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentEntity department = new DepartmentEntity();
        department.setDepartmentName(departmentDTO.getName());
        response.setMessage("Department information CREATED successfully");
        return (response);
    }

    @GetMapping("/departments/all")
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/departments/{id}")
    public DepartmentDTO getDepartment(@PathVariable int id) {

        return departmentService.findDepartmentById((long) id);
    }

    @PatchMapping("/departments/{id}")
    public ApiResponse updateDepartment(@PathVariable int id, @RequestBody Map<String, Object> departmentDetails) {
        departmentService.updateEntity(id, departmentDetails);
        ApiResponse response = new ApiResponse();
        response.setMessage("Department information UPDATED successfully");
        return (response);
    }


    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) throws IllegalAccessException {
        departmentService.deleteEntity(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Department information DELETED successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}

