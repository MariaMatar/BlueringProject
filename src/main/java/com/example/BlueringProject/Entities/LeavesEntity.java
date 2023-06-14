package com.example.BlueringProject.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "LeavesEntity", schema = "internship", catalog = "")

public class LeavesEntity {

    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "leave_type")
    private String leaveType;
    @Basic
    @Column(name = "start_date")
    private String startDate;
    @Basic
    @Column(name = "end_date")
    private String endDate;

    public Object getFromDate() {
        return null;

    }

    public Object getTillDate() {
        return null;

    }

    public void setFromDate(Object fromDate) {
        return;

    }

    public void setTillDate(Object tillDate) {
        return;

    }
}

