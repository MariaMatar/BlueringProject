package com.example.BlueringProject.Services.LeavesServices;


import com.example.BlueringProject.DTO.LeavesDTO.LeaveTypeDTO;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LeaveTypeService {

    static void deleteById(Long idValue) {
    }

    LeaveTypeDTO findLeaveTypeById(int id);

    LeaveTypeDTO create(LeaveTypeDTO leaveTypeDTO);

    LeaveTypeDTO update(LeaveTypeDTO leaveTypeDTO);

    LeaveTypeDTO get(int id);

    LeaveTypeDTO delete(int id);

    List<LeaveTypeDTO> getAll();

    ResponseEntity<LeaveTypeEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<LeaveTypeDTO> getEntity(int id, Map<String, Object> leaveTypeDTO);

    ResponseEntity<LeaveTypeDTO> getAllEntity(int id, Map<String, Object> leaveTypeDTO);

    ResponseEntity<LeaveTypeEntity> updateEntity(int id, Map<String, Object> leaveTypeDTO);


    ResponseEntity<LeaveTypeEntity> createEntity(Map<String, Object> leaveTypeDTO) throws IllegalAccessException;

}


