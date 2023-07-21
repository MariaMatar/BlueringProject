package com.example.BlueringProject.Services.ExpenseServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

    private ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeServiceImpl(EmployeeRepository employeeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public ExpenseTypeDTO create(ExpenseTypeDTO expenseTypeDTO) {
        ExpenseTypeEntityEntity expenseTypeEntity = new ExpenseTypeEntityEntity();
        ExpenseTypeEntityEntity savedExpenseTypeEntity = expenseTypeRepository.save(expenseTypeEntity);
        ExpenseTypeDTO savedExpenseTypeDTO = new ExpenseTypeDTO();
        return savedExpenseTypeDTO;
    }


    @Override
    public ExpenseTypeDTO update(ExpenseTypeDTO expenseTypeDTO) {
        return null;
    }

    @Override
    public ExpenseTypeDTO get(int id) {
        return null;
    }

    @Override
    public ExpenseTypeDTO delete(int id) {
        return null;
    }

    @Override
    public ResponseEntity<ExpenseTypeEntityEntity> deleteEntity(int id) throws IllegalAccessException {
        return null;
    }

    @Autowired
    public ExpenseTypeServiceImpl(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public ExpenseTypeEntityEntity createExpenseType(ExpenseTypeEntityEntity expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    @Override
    public String getExpenseTypeNameById(Long expenseTypeId) {
        return null;
    }

    @Override
    public List<ExpenseTypeEntityEntity> getAllExpenseTypes() {
        return null;
    }
}