package com.rayshan.service;

import com.rayshan.common.entities.Employee;
import com.rayshan.exception.ResourceNotFoundException;
import com.rayshan.repository.EmployeeRepository;
import com.rayshan.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Employee> getAllEmployees() {
        Sort sort = Sort.by("id").descending();
        return this.employeeRepository.findAll(sort);
    }

    public Employee getAllEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for employee id: " + employeeId));
        return employee;
    }


    @Transactional
    public Employee createEmployee(Employee employee) {
        Long nextHealthId = getNextHid();
        employee.setHealthId(nextHealthId);
        return this.employeeRepository.save(employee);
    }

    // This method is to generate sequence manually (uses transaction).
    @Transactional(propagation = Propagation.REQUIRED)
    public Long getNextHid() {
        Long newHid = this.sequenceRepository.getNextHid();
        this.sequenceRepository.updateHid(newHid + 1);
        return newHid;
    }
}
