package com.example.BlueringProject.Entities.LeavesEntities;

import com.example.BlueringProject.Entities.EmployeeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Setter
@Getter
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
    @Column(name = "to_Date")
    private LocalDate toDate;
    @Basic
    @Column(name = "leave_type")
    private String leaveType;
    @Basic
    @Column(name = "from_date")
    private LocalDate fromDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveEntity that = (LeaveEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(employeeId, that.employeeId)) return false;
        if (!Objects.equals(toDate, that.toDate)) return false;
        if (!Objects.equals(leaveType, that.leaveType)) return false;
        return Objects.equals(fromDate, that.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, toDate, leaveType, fromDate);
    }

    public void setEmployee(EmployeeEntity employee) {
    }

    public void setNote(String note) {
    }

}
