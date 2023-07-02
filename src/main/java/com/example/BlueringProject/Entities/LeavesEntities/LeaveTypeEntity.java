package com.example.BlueringProject.Entities.LeavesEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "leaveType", schema = "internship", catalog = "")

public class LeaveTypeEntity {
    @Id
    @Basic
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "leave_type")
    private String leaveType;


    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public void setName(String name) {

    }
}
