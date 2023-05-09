package com.training.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.training.demo.entity.Employee;


import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
    // List to hold all employees
	private List<Employee> employees = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	// Counter for generating next employee id
	private int nextId;
    
    public EmployeeServiceImpl() {
		super();
        
        // Add some initial employees to the list
		employees.add(new Employee(1l, "John", "123 Main St"));
        employees.add(new Employee(2l, "Jane", "456 Oak St"));
        employees.add(new Employee(3l, "Bob", "789 Elm St"));
        
        // Set the nextId to the number of employees + 1
        nextId = employees.size()+1;
	}

	@Override
	public Employee getEmployeeById(long id) {
		// Loop through the employees list and find the employee with the given id
		for (Employee employee : employees) {
			if (employee.getId() == id)
				return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
        // Return the employees list
        return employees;
    }

	@Override
	public Employee addEmployee(Employee employee) {
        // Set the employee's id to the nextId value, add the employee to the list, and increment nextId
        employee.setId((long) nextId);
        employees.add(employee);
        nextId++;
        System.out.println(System.getProperty("log4j.configurationFile"));
        logger.info("New employee added: " + employee);
        // Return the added employee
        return employee;
    }

	@Override
	public Employee deleteEmployee(Long id) {
        // Find the employee with the given id, remove them from the list, and return the removed employee
        Employee employee = getEmployeeById(id);
        employees.remove(employee);
        
        // Return the deleted employee
        return employee;
    }

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
        // Find the employee with the given id, update their name and address, and return the updated employee
        Employee employee = getEmployeeById(updatedEmployee.getId());
        if (employee == null) {
            return null;
        }
        employee.setName(updatedEmployee.getName());
        employee.setAddress(updatedEmployee.getAddress());
        return employee;
    }
}
