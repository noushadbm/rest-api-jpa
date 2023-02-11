package com.rayshan.service;

import com.rayshan.common.entities.Employee;
import com.rayshan.exception.ResourceNotFoundException;
import com.rayshan.repository.EmployeeRepository;
import com.rayshan.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private SequenceRepository sequenceRepository;

    @Autowired
    public EmployeeService(EmployeeRepository empRepository, SequenceRepository sequenceRepository){
        this.employeeRepository = empRepository;
        this.sequenceRepository = sequenceRepository;
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        System.out.println("Request reached here..."+ getNextHid());
        return this.employeeRepository.findAll();
    }

    public Employee getAllEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for employee id: " + employeeId));
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Long getNextHid() {
        Long newHid = this.sequenceRepository.getNextHid();
        this.sequenceRepository.updateHid(newHid + 1);
        return newHid;
    }
}
