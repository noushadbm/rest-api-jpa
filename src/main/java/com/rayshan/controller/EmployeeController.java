package com.rayshan.controller;

import com.rayshan.common.entities.Employee;
import com.rayshan.exception.ResourceNotFoundException;
import com.rayshan.repository.EmployeeRepository;
import com.rayshan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getAllEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        Employee employee = this.employeeService.getAllEmployeeById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("Request reached here...");
        return this.employeeService.createEmployee(employee);
    }
}
