package com.example.BlueringProject.Services;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity findEmployeeById(int id) {
        return employeeRepository.findById(Integer.valueOf(Integer.valueOf(id))).orElse(null);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(Integer.valueOf(Integer.valueOf(id)));
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeMapper.toEntity(employeeDTO);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return EmployeeMapper.toDTO(savedEmployeeEntity);
    }

    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employeeDTO.getId());
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employeeEntity.setAddress(employeeDTO.getAddress());
            employeeEntity.setFirstName(employeeDTO.getFirstName());
            employeeEntity.setLastName(employeeDTO.getLastName());
            employeeEntity.setPhoneNumber(employeeDTO.getPhoneNumber());
            EmployeeEntity updatedEmployeeEntity = employeeRepository.save(employeeEntity);
            return EmployeeMapper.toDTO(updatedEmployeeEntity);
        }
        return null;
    }

    public EmployeeDTO get(int id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            return EmployeeMapper.toDTO(employeeEntity);
        }
        return null;
    }

    public EmployeeDTO delete(int id) {
        employeeRepository.deleteById(id);
        return null;
    }

    public List<EmployeeDTO> getAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return EmployeeMapper.toDTOList(employeeEntities);
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


    public void deleteEntity(Object entityToDelete, Class entityToDeleteClass) throws IllegalAccessException {
        Field idField = ReflectionUtils.findRequiredField(entityToDeleteClass, "id");
        idField.setAccessible(true);
        Object idValue = idField.get(entityToDelete);
        EmployeeService.deleteById((Long) idValue);

    }

    @Override
    public ResponseEntity<EmployeeEntity> deleteEntity(int id) throws IllegalAccessException {
        EmployeeEntity entityToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(entityToDelete);
        return ResponseEntity.ok(entityToDelete);
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

    @Override
    public ResponseEntity<EmployeeEntity> getEntity(int id, Map<String, Object> employeeDTO) {
        EmployeeEntity entityToGet = employeeRepository.findById(id).orElseThrow();
        Class entityToGetClass = EmployeeEntity.class;
        getEntity(employeeDTO, entityToGet, entityToGetClass);
        employeeRepository.saveAndFlush(entityToGet);
        return ResponseEntity.ok(entityToGet);
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
    public ResponseEntity<EmployeeEntity> getAllEntity(int id, Map<String, Object> employeeDTO) {
        EmployeeEntity entityToGetAll = employeeRepository.findById(id).orElseThrow();
        Class entityToGetAllClass = EmployeeEntity.class;
        getAllEntity(employeeDTO, entityToGetAll, entityToGetAllClass);
        employeeRepository.saveAndFlush(entityToGetAll);
        return ResponseEntity.ok(entityToGetAll);
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

}

