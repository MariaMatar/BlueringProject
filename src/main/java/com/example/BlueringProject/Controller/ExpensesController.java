package com.example.BlueringProject.Controller;

import com.example.BlueringProject.ApiResponse;
import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.BlueringProject.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.BlueringProject.Entities.ExpenseClaimEntityEntity;
import com.example.BlueringProject.Entities.ExpenseTypeEntityEntity;
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
import java.util.Date;
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
    public ExpensesController(
            ExpenseClaimService expenseClaimService,
            ExpenseTypeService expenseTypeService
    ) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
    }

    public ExpensesController(
            ExpenseClaimService expenseClaimService,
            ExpenseTypeService expenseTypeService,
            ExpenseClaimEntryService expenseClaimEntryService
    ) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
        this.expenseClaimEntryService = expenseClaimEntryService;
    }

    // Define expense claim types
    @PostMapping("/expense-types")
    public ExpenseTypeEntityEntity createExpenseType(@RequestBody ExpenseTypeEntityEntity expenseTypeEntity) {
        return expenseTypeRepository.save(expenseTypeEntity);
    }

    // Submit the expense
    @PostMapping("/submit-expense")
    public ApiResponse submitExpense(@RequestBody ExpenseClaimDTO expenseClaimDTO) {
        ExpenseClaimEntityEntity expenseClaimEntity = new ExpenseClaimEntityEntity();
        expenseClaimEntity.setExpenseClaimDate((java.sql.Date) new Date(System.currentTimeMillis()));
//        expenseClaimEntity.setDescription(expenseClaimEntryDTO.getDescription());
//        expenseClaimEntity.setExpenseClaimTotal(expenseClaimDTO.getTotal()); // Total amount

        // Save the expense claim entity
        expenseClaimService.saveExpenseClaimEntity(expenseClaimEntity);
        response.setMessage("Expense claim submitted successfully");
        return response;
    }

    // Get total claims of each type per employee
    @GetMapping("/total-claims")
    public ResponseEntity<Map<String, Map<String, BigDecimal>>> getTotalClaimsPerTypePerEmployee() {
        List<ExpenseClaimEntityEntity> expenseClaims = expenseClaimService.getAllExpenseClaims();
        List<ExpenseTypeEntityEntity> expenseTypes = expenseTypeService.getAllExpenseTypes();

        Map<String, Map<String, BigDecimal>> totalClaimsData = new HashMap<>();

        for (ExpenseClaimEntityEntity expenseClaim : expenseClaims) {
            String employeeId = expenseClaim.getEmployeeId().toString();
            Map<String, BigDecimal> claimsPerType = totalClaimsData.computeIfAbsent(employeeId, k -> new HashMap<>());

            List<ExpenseClaimEntryDTO> entries = expenseClaimEntryService.getExpenseClaimEntriesByClaimId(expenseClaim.getExpenseClaimId());
            for (ExpenseClaimEntryDTO entry : entries) {
                String expenseTypeId = String.valueOf(entry.getExpenseTypeId());
                String expenseTypeName = getExpenseTypeNameById(expenseTypes, expenseTypeId);
//                BigDecimal totalAmount = entry.getExpenseClaimEntryTotal();

//                claimsPerType.put(expenseTypeName, claimsPerType.getOrDefault(expenseTypeName, BigDecimal.ZERO).add(totalAmount));
            }
        }
        return ResponseEntity.ok(totalClaimsData);
    }

    // Utility method to get the expense type name based on the expenseTypeId
    private String getExpenseTypeNameById(List<ExpenseTypeEntityEntity> expenseTypes, String expenseTypeId) {
        for (ExpenseTypeEntityEntity expenseType : expenseTypes) {
            if (String.valueOf(expenseType.getExpenseTypeId()).equals(expenseTypeId)) {
                return expenseType.getExpenseTypeName();
            }
        }
        return "";
    }
}

