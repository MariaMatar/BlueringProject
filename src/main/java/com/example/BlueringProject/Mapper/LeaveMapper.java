package com.example.BlueringProject.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.BlueringProject.DTO.LeavesDTO.LeaveDTO;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveEntity;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);

    LeaveDTO LeaveEntityToLeaveDTO(LeaveEntity cmUserEntity);

    LeaveEntity userDTOToCmUserEntity(LeaveDTO userDTO);
}
