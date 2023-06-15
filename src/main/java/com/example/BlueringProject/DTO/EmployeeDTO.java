package com.example.BlueringProject.DTO;

import lombok.Data;

import java.util.List;
@Data
public class EmployeeDTO {
    private int id;
    private String address;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private List<LeavesDTO> leaves;
}

