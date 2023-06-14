package com.example.BlueringProject.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity

@Table(name = "employee", schema = "internship", catalog = "")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    public LeavesEntity[] getLeaves() {
        return null;

    }
    public void setLeaves(LeavesEntity[] leaves) {
        return ;

    }

    public void setLeaves(List<LeavesEntity> leavesEntityList) {
    }
}

