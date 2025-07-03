package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPQL Query
    @Query("SELECT e FROM Employee e WHERE LOWER(e.employeeName) LIKE LOWER(CONCAT('%', :name, '%')) AND e.employeeSalary >= :salary")
    List<Employee> findByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    // Native SQL Query
    @Query(value = "SELECT * FROM employees WHERE employee_name LIKE :name AND employee_salary >= :salary", nativeQuery = true)
    List<Employee> findByNameAndSalaryNative(@Param("name") String name, @Param("salary") Double salary);
    
    @Query("SELECT e FROM Employee e WHERE LOWER(e.department) LIKE LOWER(CONCAT('%', :department, '%'))")
    List<Employee> findByDepartment(@Param("department") String department);

    @Query(value = "SELECT * FROM employees WHERE LOWER(department) LIKE LOWER(CONCAT('%', :department, '%'))", nativeQuery = true)
    List<Employee> findByDepartmentNative(@Param("department") String department);
}
