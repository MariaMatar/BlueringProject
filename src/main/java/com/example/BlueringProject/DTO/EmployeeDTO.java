package com.example.BlueringProject.DTO;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private int id;
    private String address;
    private String name;
    private String email;
    //    private List<LeavesDTO> leaves;
    private Long departmentId;
    private List<DepartmentDTO> departments;

}

