package com.example.BlueringProject.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

@Table(name = "employee")


public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;


    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "department_id")
    private Long departmentId;

}
