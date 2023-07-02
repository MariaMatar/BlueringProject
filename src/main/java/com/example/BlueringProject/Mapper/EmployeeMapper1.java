package com.example.BlueringProject.Mapper;

import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")

public interface EmployeeMapper1 {

    EmployeeMapper1 INSTANCE = Mappers.getMapper(EmployeeMapper1.class);

    EmployeeDTO EmployeeEntityToEmployeeDTO(EmployeeEntity cmUserEntity);

    EmployeeEntity userDTOToCmUserEntity(EmployeeDTO userDTO);
}

