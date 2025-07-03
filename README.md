# Employee Management System

A simple Employee Management web application built with Spring Boot, Spring Data JPA, and H2 Database.

## Features

- RESTful API for managing employees (CRUD operations)
- In-memory H2 database for development and testing
- Spring Data JPA for data persistence
- Spring Boot for rapid application development

## Technologies Used

- Java 17
- Spring Boot 3.4.1
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository:**
   ```powershell
   git clone <your-repo-url>
   cd employee_management
   ```

2. **Build the project:**
   ```powershell
   mvnw clean install
   ```

3. **Run the application:**
   ```powershell
   mvnw spring-boot:run
   ```

   The application will start on [http://localhost:8080](http://localhost:8080).

### API Endpoints

| Method | Endpoint           | Description                |
|--------|--------------------|----------------------------|
| GET    | /employees         | Get all employees          |
| GET    | /employees/{id}    | Get employee by ID         |
| POST   | /employees         | Create a new employee      |
| PUT    | /employees/{id}    | Update an existing employee|
| DELETE | /employees/{id}    | Delete an employee         |

### H2 Database Console

- Access the H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: *(leave blank)*

## Project Structure

```
src/
  main/
    java/
      com/example/employee_management/
        EmployeeManagementApplication.java
        controller/
          EmployeeController.java
        model/
          Employee.java
        repository/
          EmployeeRepository.java
    resources/
      application.properties
      static/
      templates/
  test/
    java/
      com/example/employee_management/
        EmployeeManagementApplicationTests.java
```

## Configuration

Application properties can be found in `src/main/resources/application.properties`.

## report for more information:

[Employees managmant report.pdf](https://github.com/user-attachments/files/21040399/Employees.managmant.report.pdf)


**happy to work together**
