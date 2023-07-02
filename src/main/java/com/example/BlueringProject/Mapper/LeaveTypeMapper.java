package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.DTO.LeavesDTO.LeaveTypeDTO;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {
    LeaveTypeMapper INSTANCE = Mappers.getMapper(LeaveTypeMapper.class);

    LeaveTypeDTO LeaveTypeEntityToLeaveTypeDTO(LeaveTypeEntity cmUserEntity);

    LeaveTypeEntity userDTOToCmUserEntity(LeaveTypeDTO userDTO);
}
