package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.DTO.LeavesDTO;
import com.example.BlueringProject.Entities.LeavesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public static EmployeeDTO toDTO(EmployeeEntity employeeentity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employeeentity.getId());
        dto.setAddress(employeeentity.getAddress());
        dto.setFirstName(employeeentity.getFirstName());
        dto.setLastName(employeeentity.getLastName());
        dto.setPhoneNumber(employeeentity.getPhoneNumber());

        List<LeavesDTO> leaveDTOList = new ArrayList<>();
        if (employeeentity.getLeaves() != null) {
            for (LeavesEntity leavesEntity : employeeentity.getLeaves()) {
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
        return employeeEntities.stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
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

    public EmployeeDTO toDto(Optional<EmployeeEntity> employeeEntity) {
        return null;
    }
}
