package com.example.BlueringProject.Services.LeavesServices;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveEntity;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import com.example.BlueringProject.Repositories.LeavesRepos.LeaveRepository;
import com.example.BlueringProject.Repositories.LeavesRepos.LeaveTypeRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    private final LeaveRepository leaveRepository;
    private final LeaveTypeRepository leaveTypeRepository;

//    public void LeaveService(LeaveRepository leaveRepository, LeaveTypeRepository leaveTypeRepository) {
//        this.leaveRepository = leaveRepository;
//        this.leaveTypeRepository = leaveTypeRepository;
//    }

    public LeaveServiceImpl(LeaveRepository leaveRepository, LeaveTypeRepository leaveTypeRepository) {
        this.leaveRepository = leaveRepository;
        this.leaveTypeRepository = leaveTypeRepository;
    }

    public LeaveEntity submitLeaveRequest(Long employeeId, Long leaveTypeId, LocalDate fromDate, LocalDate toDate, String note) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(Math.toIntExact(employeeId));

        LeaveTypeEntity leaveType = leaveTypeRepository.getById(Math.toIntExact(leaveTypeId));

        LeaveEntity leave = new LeaveEntity();
        leave.setEmployee(employee);
        leave.setLeaveType(String.valueOf(leaveType));
        leave.setFromDate(fromDate);
        leave.setToDate(toDate);
        leave.setFromDate(LocalDate.ofEpochDay(Period.between(fromDate, toDate).getDays() + 1)); // Calculate number of days
        leave.setNote(note);

        return leaveRepository.save(leave);
    }

    @Override
    public LeaveEntity submitLeaveRequest(Integer employeeId, Integer leaveTypeId, LocalDate fromDate, LocalDate toDate, String note) {
        return null;
    }

    public List<LeaveEntity> getLeavesByEmployeeAndDateRange(Integer employeeId, LocalDate fromDate, LocalDate toDate) {
        return leaveRepository.findByEmployeeIdAndFromDateBetween(employeeId, fromDate, toDate);
    }

    public Page<LeaveEntity> getLeavesByTypeAndEmployee(LeaveTypeEntity leaveType, Integer employeeId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return leaveRepository.findByLeaveTypeAndEmployeeId(leaveType, employeeId, pageable);
    }
}


