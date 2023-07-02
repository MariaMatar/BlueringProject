package com.example.BlueringProject.Services.LeavesServices;

import com.example.BlueringProject.DTO.LeavesDTO.LeaveTypeDTO;
import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import com.example.BlueringProject.Mapper.LeaveTypeMapper;
import com.example.BlueringProject.Repositories.LeavesRepos.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;

    @Autowired
    private LeaveTypeMapper leaveTypeMapper;

    public LeaveTypeServiceImpl(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
        this.leaveTypeMapper = leaveTypeMapper;
    }

    @Override
    public LeaveTypeDTO findLeaveTypeById(int id) {
        return leaveTypeMapper.LeaveTypeEntityToLeaveTypeDTO(leaveTypeRepository.findById(id).get());
    }

    @Override
    public LeaveTypeDTO create(LeaveTypeDTO leaveTypeDTO) {
        return null;
    }

    @Override
    public LeaveTypeDTO update(LeaveTypeDTO leaveTypeDTO) {
        return null;
    }

    @Override
    public LeaveTypeDTO get(int id) {
        return null;
    }

    @Override
    public LeaveTypeDTO delete(int id) {
        return null;
    }

    @Override
    public List<LeaveTypeDTO> getAll() {
        return null;
    }

    public void deleteLeaveTypeById(int id) {
        leaveTypeRepository.deleteById(Integer.valueOf(id));
    }

    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
        // Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findRequiredField(entityToUpdateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToUpdate, v);
        });

    }

    @Override
    public ResponseEntity<LeaveTypeEntity> updateEntity(int id, Map<String, Object> LeaveTypeDTO) {
        LeaveTypeEntity entityToUpdate = leaveTypeRepository.findById(id).orElseThrow();
        Class entityToUpdateClass = LeaveTypeEntity.class;
        updateEntity(LeaveTypeDTO, entityToUpdate, entityToUpdateClass);
        leaveTypeRepository.saveAndFlush(entityToUpdate);
        return ResponseEntity.ok(entityToUpdate);
    }


    @Override
    public ResponseEntity<LeaveTypeEntity> deleteEntity(int id) throws IllegalAccessException {
        LeaveTypeEntity entityToDelete = leaveTypeRepository.findById(id).orElseThrow();
        leaveTypeRepository.delete(entityToDelete);
        return ResponseEntity.ok(entityToDelete);
    }

    @Override
    public ResponseEntity<LeaveTypeDTO> getEntity(int id, Map<String, Object> leaveTypeDTO) {
        return null;
    }


    public void getEntity(Map<String, Object> entityDTO, Object entityToGet, Class entityToGetClass) {
        // Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findRequiredField(entityToGetClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToGet, v);

        });

    }


    public void getAllEntity(Map<String, Object> entityDTO, Object entityToGetAll, Class entityToGetAllClass) {
        // Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findRequiredField(entityToGetAllClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToGetAll, v);

        });

    }

    @Override
    public ResponseEntity<LeaveTypeDTO> getAllEntity(int id, Map<String, Object> leaveTypeDTO) {
        LeaveTypeEntity entityToGetAll = leaveTypeRepository.findById(id).orElseThrow();
        Class entityToGetAllClass = LeaveTypeEntity.class;
        getAllEntity(leaveTypeDTO, entityToGetAll, entityToGetAllClass);
        leaveTypeRepository.saveAndFlush(entityToGetAll);
        LeaveTypeDTO leaveTypeDto = leaveTypeMapper.LeaveTypeEntityToLeaveTypeDTO(entityToGetAll);
        return ResponseEntity.ok(leaveTypeDto);
    }


    public void createEntity(Map<String, Object> entityDTO, Object entityToCreate, Class entityToCreateClass) throws IllegalAccessException {
        entityDTO.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(entityToCreateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToCreate, v);
        });
    }


    @Override
    public ResponseEntity<LeaveTypeEntity> createEntity(Map<String, Object> leaveTypeDTO) throws IllegalAccessException {
        LeaveTypeEntity entityToCreate = new LeaveTypeEntity();
        Class<LeaveTypeEntity> entityToCreateClass = LeaveTypeEntity.class;
        createEntity(leaveTypeDTO, entityToCreate, entityToCreateClass);
        leaveTypeRepository.saveAndFlush(entityToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityToCreate);
    }


}

