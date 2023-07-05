package com.example.BlueringProject.Services.EmployeeServices;

import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseTypeEntity;
import com.example.BlueringProject.Repositories.EmployeeRepository;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseTypeRepository;
import com.example.BlueringProject.Services.ExpenseServices.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

    private ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeServiceImpl(EmployeeRepository employeeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public ExpenseTypeDTO create(ExpenseTypeDTO expenseTypeDTO) {
        ExpenseTypeEntity expenseTypeEntity = new ExpenseTypeEntity();
        ExpenseTypeEntity savedExpenseTypeEntity = expenseTypeRepository.save(expenseTypeEntity);
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
    public ResponseEntity<ExpenseTypeEntity> deleteEntity(int id) throws IllegalAccessException {
        return null;
    }

    @Autowired
    public ExpenseTypeServiceImpl(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public ExpenseTypeEntity createExpenseType(ExpenseTypeEntity expenseType) {
        return expenseTypeRepository.save(expenseType);
    }
}