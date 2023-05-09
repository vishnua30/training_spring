package com.training.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.dto.EmployeeResponseDto;
import com.training.demo.dto.EmployeeResponseDto.ResponseStatus;
import com.training.demo.entity.Employee;
import com.training.demo.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public EmployeeResponseDto getEmployees() {
        List<Employee> employees = employeeService.getEmployees();

        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setResponseCode(HttpStatus.OK);
        response.setDataSize(employees.size());
        response.setData(employees);

        return response;
    }

    @PostMapping("/employees")
    public EmployeeResponseDto addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);

        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setResponseCode(HttpStatus.CREATED);
        response.setData(addedEmployee);

        return response;
    }

    @PutMapping("/employees/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeResponseDto response = new EmployeeResponseDto();
		if (employee != null) {
			employee.setName(updatedEmployee.getName());
			employee.setAddress(updatedEmployee.getAddress());
			
			Employee updated = employeeService.updateEmployee(employee);
			response.setResponseStatus(ResponseStatus.SUCCESS);
			response.setResponseCode(HttpStatus.OK);
			response.setData(updated);
		} else {
			response.setResponseStatus(ResponseStatus.no_employee_found);
			response.setResponseCode(HttpStatus.NOT_FOUND);
		}

        return response;
    }

    @DeleteMapping("employees/{id}")
    public EmployeeResponseDto deleteEmployee(@PathVariable Long id) {
        Employee deleted = employeeService.deleteEmployee(id);

        EmployeeResponseDto response = new EmployeeResponseDto();
		if (deleted == null) {
			response.setResponseStatus(ResponseStatus.no_employee_found);
			response.setResponseCode(HttpStatus.NOT_FOUND);

		} else {
			response.setData(deleted);
			response.setResponseStatus(ResponseStatus.SUCCESS);
			response.setResponseCode(HttpStatus.OK);

		}
        return response;
    }

    @ExceptionHandler(Exception.class)
    public EmployeeResponseDto handleAllExceptions(Exception ex) {
        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setResponseStatus(ResponseStatus.FAIL);
        response.setResponseCode(HttpStatus.BAD_REQUEST);

        return response;
    }
}
