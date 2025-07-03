package com.example.employee_management.model;
import jakarta.persistence.*;         // Brings in JPA annotations used to map the 
//class and its fields to database entities.
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Integer employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private Double employeeSalary;

    @Column(nullable = false)
    private String department;
    
    public Employee() {}

    public Employee(String employeeName, Double employeeSalary ,String department) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.department = department;
    }

    // Getters and Setters
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
