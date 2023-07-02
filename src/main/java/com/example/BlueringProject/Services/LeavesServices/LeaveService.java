package com.example.BlueringProject.Services.LeavesServices;

import com.example.BlueringProject.Entities.LeavesEntities.LeaveEntity;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface LeaveService {
    LeaveEntity submitLeaveRequest(Integer employeeId, Integer leaveTypeId, LocalDate fromDate, LocalDate toDate, String note);

    List<LeaveEntity> getLeavesByEmployeeAndDateRange(Integer employeeId, LocalDate fromDate, LocalDate toDate);

    Page<LeaveEntity> getLeavesByTypeAndEmployee(LeaveTypeEntity leaveType, Integer employeeId, int page, int size);
}
