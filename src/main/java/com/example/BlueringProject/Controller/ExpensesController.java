package com.example.BlueringProject.Controller;

import com.example.BlueringProject.ApiResponse;
import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.BlueringProject.Entities.EmployeeEntity;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntity;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseClaimEntryEntity;
import com.example.BlueringProject.Entities.ExpensesClaims.ExpenseTypeEntity;
import com.example.BlueringProject.Repositories.DepartmentRepository;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseClaimEntryRepository;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseClaimRepository;
import com.example.BlueringProject.Repositories.ExpenseRepos.ExpenseTypeRepository;
import com.example.BlueringProject.Services.EmployeeServices.EmployeeService;
import com.example.BlueringProject.Services.ExpenseServices.ExpenseClaimEntryService;
import com.example.BlueringProject.Services.ExpenseServices.ExpenseClaimService;
import com.example.BlueringProject.Services.ExpenseServices.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("bluering/api/v1/expenses")
public class ExpensesController {
    private final ExpenseClaimService expenseClaimService;
    private final ExpenseTypeService expenseTypeService;
    private ExpenseClaimEntryService expenseClaimEntryService;
    public ApiResponse response;
    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private ExpenseClaimEntryRepository expenseClaimEntryRepository;

    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public ExpensesController(ExpenseClaimService expenseClaimService, ExpenseTypeService expenseTypeService) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
    }

    public ExpensesController(ExpenseClaimService expenseClaimService, ExpenseTypeService expenseTypeService, ExpenseClaimEntryService expenseClaimEntryService) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
        this.expenseClaimEntryService = expenseClaimEntryService;
    }

    // Define expense claim types
    @PostMapping("/expense-types")
    public ExpenseTypeEntity createExpenseType(@RequestBody ExpenseTypeEntity expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    // Submit the expense
    @PostMapping("/submit-expense")
    public ApiResponse submitExpense(@RequestBody ExpenseClaimDTO expenseClaimDTO) {
        ExpenseClaimEntity expenseClaim = new ExpenseClaimEntity();
        expenseClaim.setExpenseClaimDate(LocalDate.now());
        expenseClaim.setDescription(expenseClaimDTO.getDescription());
        expenseClaim.setExpenseClaimTotal(expenseClaimDTO.getTotal()); // Total amount

        // Save the expense claim entity
        expenseClaimService.saveExpenseClaimEntity(expenseClaim);
        response.setMessage("Expense claim submitted successfully");
        return (response);
    }

    // Get total claims per type per employee
    @GetMapping("/total-claims")
    public ResponseEntity<Map<String, Map<String, BigDecimal>>> getTotalClaimsPerTypePerEmployee() {
        List<ExpenseClaimEntity> expenseClaims = expenseClaimRepository.findAll();
        Map<String, Map<String, BigDecimal>> totalClaimsData = new HashMap<>();

        for (ExpenseClaimEntity expenseClaimEntity : expenseClaims) {
            String employeeId = expenseClaimEntity.getEmployeeId().toString();
            Map<String, BigDecimal> claimsPerType = totalClaimsData.computeIfAbsent(employeeId, k -> new HashMap<>());

            List<ExpenseClaimEntryEntity> entries = expenseClaimEntryRepository.findByExpenseClaimEntity(expenseClaimEntity);
            for (ExpenseClaimEntryEntity entry : entries) {
                String expenseTypeName = entry.getExpenseType().getExpenseTypeName();
                BigDecimal totalAmount = entry.getTotal();

                claimsPerType.put(expenseTypeName, claimsPerType.getOrDefault(expenseTypeName, BigDecimal.ZERO).add(totalAmount));

            }
        }
//        return ResponseEntity.ok(totalClaimsData);
    }
}
