package com.example.BlueringProject.DTO.LeavesDTO;

import lombok.Data;

@Data
public class LeaveDTO {

    private int id;
    private String leaveType;
    private String from;
    private String to;
    private int numberOfDays;
    private String note;
    private int employeeId;
    private int leaveTypeId;
}
