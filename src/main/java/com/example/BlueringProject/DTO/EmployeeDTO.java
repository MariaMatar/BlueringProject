package com.example.BlueringProject.DTO;

import java.util.List;

public class EmployeeDTO {
    private int id;
    private String address;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private List<LeavesDTO> leaves;


    public void setId(int id) {
        this.id = id;

    }
    public void setAddress(String address) {
        this.address = address;

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }
    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;

    }
    public void setLeaves(List<LeavesDTO> leaves) {
        this.leaves = leaves;

    }
    public int getId() {
        return id;

    }
    public String getAddress() {
        return address;

    }
    public String getFirstName() {
        return firstName;

    }
    public String getLastName() {
        return lastName;

    }
    public Integer getPhoneNumber() {
        return phoneNumber;

    }
    public List<LeavesDTO> getLeaves() {
        return leaves;

    }

    public void setId(Long id) {
    }

    public void setPhoneNumber(long phoneNumber) {
    }

}

