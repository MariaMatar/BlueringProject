package com.example.BlueringProject.Services.DepartmentServices;

import com.example.BlueringProject.DTO.DepartmentDTO;
import com.example.BlueringProject.Entities.DepartmentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    static void deleteById(int idValue) {
    }

    DepartmentDTO findDepartmentById(Integer id);

    DepartmentDTO findDepartmentById(Long id);

    DepartmentDTO create(DepartmentDTO departmentDTO);

    DepartmentDTO update(DepartmentDTO departmentDTO);

    DepartmentDTO get(int id);

    DepartmentDTO delete(int id);

    List<DepartmentDTO> getAll();

    ResponseEntity<DepartmentEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<DepartmentDTO> getEntity(int id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentDTO> getAllEntity(int id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentEntity> updateEntity(int id, Map<String, Object> departmentDTO);


    void deleteDepartmentById(int id);

    void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass);

    ResponseEntity<DepartmentEntity> updateEntity(long id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentEntity> deleteEntity(long id) throws IllegalAccessException;

    ResponseEntity<DepartmentDTO> getEntity(long id, Map<String, Object> departmentDTO);

    void getEntity(Map<String, Object> entityDTO, Object entityToGet, Class entityToGetClass);

    void getAllEntity(Map<String, Object> entityDTO, Object entityToGetAll, Class entityToGetAllClass);

    ResponseEntity<DepartmentDTO> getAllEntity(long id, Map<String, Object> departmentDTO);

    void createEntity(Map<String, Object> entityDTO, Object entityToCreate, Class entityToCreateClass) throws IllegalAccessException;

    ResponseEntity<DepartmentEntity> updateEntity(Integer id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentEntity> deleteEntity(Integer id);

    ResponseEntity<DepartmentDTO> getEntity(Integer id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentDTO> getAllEntity(Integer id, Map<String, Object> departmentDTO);

    ResponseEntity<DepartmentEntity> createEntity(Map<String, Object> departmentDTO) throws IllegalAccessException;

    String getDepartment(Integer id);
}

