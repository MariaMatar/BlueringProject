package com.example.BlueringProject.Services;

import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.DTO.EmployeeDTO;
import com.example.BlueringProject.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity findEmployeeById(int id) {
        return employeeRepository.findById(Integer.valueOf(Integer.valueOf(id))).orElse(null);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return  employeeRepository.findAll();
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

}
