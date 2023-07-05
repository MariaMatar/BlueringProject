package com.example.BlueringProject.Services.EmployeeServices;

import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Mapper.EmployeeMapper1;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper1 employeeMapper1;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
//        this.employeeMapper1 = employeeMapper1;
    }

    @Override
    public EmployeeDTO findEmployeeById(int id) {
        return employeeMapper1.EmployeeEntityToEmployeeDTO(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO get(int id) {
        return null;
    }

    @Override
    public EmployeeDTO delete(int id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return null;
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
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
    public ResponseEntity<EmployeeEntity> updateEntity(int id, Map<String, Object> employeeDTO) {
        EmployeeEntity entityToUpdate = employeeRepository.findById(id).orElseThrow();
        Class entityToUpdateClass = EmployeeEntity.class;
        updateEntity(employeeDTO, entityToUpdate, entityToUpdateClass);
        employeeRepository.saveAndFlush(entityToUpdate);
        return ResponseEntity.ok(entityToUpdate);
    }


    @Override
    public ResponseEntity<EmployeeEntity> deleteEntity(int id) throws IllegalAccessException {
        EmployeeEntity entityToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(entityToDelete);
        return ResponseEntity.ok(entityToDelete);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEntity(int id, Map<String, Object> employeeDTO) {
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
    public ResponseEntity<EmployeeDTO> getAllEntity(int id, Map<String, Object> employeeDTO) {
        EmployeeEntity entityToGetAll = employeeRepository.findById(id).orElseThrow();
        Class entityToGetAllClass = EmployeeEntity.class;
        getAllEntity(employeeDTO, entityToGetAll, entityToGetAllClass);
        employeeRepository.saveAndFlush(entityToGetAll);
        EmployeeDTO employeeDto = employeeMapper1.EmployeeEntityToEmployeeDTO(entityToGetAll);
        return ResponseEntity.ok(employeeDto);
    }


    public void createEntity(Map<String, Object> entityDTO, Object entityToCreate, Class entityToCreateClass) throws IllegalAccessException {
        entityDTO.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(entityToCreateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToCreate, v);
        });
    }


    @Override
    public ResponseEntity<EmployeeEntity> createEntity(Map<String, Object> employeeDTO) throws IllegalAccessException {
        EmployeeEntity entityToCreate = new EmployeeEntity();
        Class<EmployeeEntity> entityToCreateClass = EmployeeEntity.class;
        createEntity(employeeDTO, entityToCreate, entityToCreateClass);
        employeeRepository.saveAndFlush(entityToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityToCreate);
    }

    public List<EmployeeEntity> getEmployeesByDepartment(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public EmployeeEntity getAuthenticatedEmployee() {
        return null;
    }

}

