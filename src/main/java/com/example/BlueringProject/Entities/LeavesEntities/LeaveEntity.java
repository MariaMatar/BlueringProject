package com.example.BlueringProject.Entities.LeavesEntities;

import com.example.BlueringProject.Entities.EmployeeEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leaves_entity", schema = "internship", catalog = "")
public class LeaveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic
    @Column(name = "end_date")
    private String endDate;
    @Basic
    @Column(name = "leave_type")
    private String leaveType;
    @Basic
    @Column(name = "start_date")
    private String startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveEntity that = (LeaveEntity) o;

        if (id != that.id) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (leaveType != null ? !leaveType.equals(that.leaveType) : that.leaveType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (leaveType != null ? leaveType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }

    public void setEmployee(EmployeeEntity employee) {
    }

    public void setFromDate(LocalDate fromDate) {
    }

    public void setToDate(LocalDate toDate) {
    }

    public void setNote(String note) {
    }
}
