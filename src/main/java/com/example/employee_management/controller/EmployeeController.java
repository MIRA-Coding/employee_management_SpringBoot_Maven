package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String welcome() {
        return "Welcome to the Employee Management System!";
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        if (employee.getEmployeeSalary() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Salary cannot be negative.");
        }
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }


    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name, @RequestParam Double salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }
    
    @GetMapping("/search/department")
    public List<Employee> searchByDepartment(@RequestParam String department) {
        return employeeRepository.findByDepartmentNative(department);
    }
}
