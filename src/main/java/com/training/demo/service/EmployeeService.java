package com.training.demo.service;

import java.util.List;

import com.training.demo.entity.Employee;

public interface EmployeeService {
	 // Method to return employee for a given id
    Employee getEmployeeById(long id);
    
    // Method that returns all the employees
    List<Employee> getEmployees();
    
    // Method to add a new employee   
    Employee addEmployee(Employee employee);
    
    // Method to delete an employee  
    Employee deleteEmployee(Long id);
    
    // Method to update an employee
    Employee updateEmployee(Employee updatedEmployee);
    
}
