package com.rayshan.controller;

import com.rayshan.common.data.BaseRequest;
import com.rayshan.common.entities.Employee;
import com.rayshan.exception.ResourceNotFoundException;
import com.rayshan.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.rayshan.common.Constants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(BaseRequest request) {
        logger.info("Get all employees API invoked.");
        if(!Objects.isNull(request.getPageNo())) {
            logger.info("Will return paginated result.");
            int pgSize = Objects.isNull(request.getPageSize()) ? DEFAULT_PAGE_SIZE : request.getPageSize();
            return this.employeeService.getAllEmployees(request.getPageNo(), pgSize);
        }
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getAllEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        logger.info("Get all employee by id API invoked. Employee ID: {}", employeeId);
        Employee employee = this.employeeService.getAllEmployeeById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("Create employee API invoked. Employee name: {} {}", employee.getFirstName(), employee.getLastName());
        return this.employeeService.createEmployee(employee);
    }
}
