package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.DTO.LeavesDTO;
import com.example.BlueringProject.Entities.LeavesEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());

        List<LeavesDTO> leaveDTOList = new ArrayList<>();
        if (entity.getLeaves() != null) {
            for (LeavesEntity leavesEntity : entity.getLeaves()) {
                LeavesDTO leavesDTO = new LeavesDTO();
                leavesDTO.setFromDate(leavesEntity.getFromDate());
                leavesDTO.setTillDate(leavesEntity.getTillDate());
                leaveDTOList.add(leavesDTO);
            }
        }
        dto.setLeaves(leaveDTOList);

        return dto;
    }

    public static List<EmployeeDTO> toDTOList(List<EmployeeEntity> employeeEntities) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeDTO employeeDTO = toDTO(employeeEntity);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    public static EmployeeEntity toEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());

        List<LeavesEntity> leavesEntityList = new ArrayList<>();
        if (employeeDTO.getLeaves() != null) {
            for (LeavesDTO leavesDTO : employeeDTO.getLeaves()) {
                LeavesEntity leavesEntity = new LeavesEntity();
                leavesEntity.setFromDate(leavesDTO.getFromDate());
                leavesEntity.setTillDate(leavesDTO.getTillDate());
                leavesEntityList.add(leavesEntity);
            }
        }
        employeeEntity.setLeaves(leavesEntityList);

        return employeeEntity;
    }

}
