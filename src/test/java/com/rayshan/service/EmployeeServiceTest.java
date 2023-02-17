package com.rayshan.service;

import com.rayshan.common.entities.Employee;
import com.rayshan.repository.EmployeeRepository;
import com.rayshan.repository.SequenceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    private static final int PAGE_SIZE = 3;
    @Mock
    private EmployeeRepository employeeMockRepository;
    @Mock
    private SequenceRepository sequenceMockRepository;
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        //when(listMock.add(anyString())).thenReturn(false);
//        List<Employee> mockList = getUserList();
//        when(employeeMockRepository.findAll(any(Sort.class))).thenReturn(mockList);
//        this.employeeService = new EmployeeService(this.employeeMockRepository, this.sequenceMockRepository);
    }

    @AfterEach
    public void tearDown() {
        // Resetting the service object.
        this.employeeService = null;
    }

    @Test
    public void getAllEmployees() {
        // GIVEN
        List<Employee> mockList = getUserList();
        when(employeeMockRepository.findAll(any(Sort.class))).thenReturn(mockList);
        this.employeeService = new EmployeeService(this.employeeMockRepository, this.sequenceMockRepository);

        // WHEN
        List<Employee> employees = employeeService.getAllEmployees();

        // THEN
        Assertions.assertIterableEquals(getUserList(), employees);
        verify(employeeMockRepository).findAll(any(Sort.class));
    }

    @Test
    public void getEmployeesPaginated() {
        // GIVEN
        Pageable page0 =
                PageRequest.of(0, PAGE_SIZE, Sort.by("id").descending());
        Pageable page1 =
                PageRequest.of(1, PAGE_SIZE, Sort.by("id").descending());
        when(employeeMockRepository.findAll(page0)).thenReturn(new PageImpl<>(getUserList()));
        when(employeeMockRepository.findAll(page1)).thenReturn(new PageImpl<>(getUserListPage1()));
        this.employeeService = new EmployeeService(this.employeeMockRepository, this.sequenceMockRepository);

        // WHEN
        List<Employee> employeesPage0 = employeeService.getAllEmployees(0, PAGE_SIZE);
        // THEN
        Assertions.assertIterableEquals(getUserList(), employeesPage0);
        verify(employeeMockRepository).findAll(any(Pageable.class));

        // WHEN
        List<Employee> employeesPage1 = employeeService.getAllEmployees(1, PAGE_SIZE);
        //THEN
        Assertions.assertIterableEquals(getUserListPage1(), employeesPage1);
        verify(employeeMockRepository, times(2)).findAll(any(Pageable.class));

    }

    private List<Employee> getUserList() {
        List<Employee> mockList = new ArrayList<>();
        mockList.add(new Employee("first", "last", "@email", 1L));
        mockList.add(new Employee("first2", "last2", "@email", 2L));
        mockList.add(new Employee("first3", "last3", "@email", 3L));
        return mockList;
    }

    private List<Employee> getUserListPage1() {
        List<Employee> mockList = new ArrayList<>();
        mockList.add(new Employee("p1first", "last", "@email", 1L));
        mockList.add(new Employee("p1first2", "last2", "@email", 2L));
        mockList.add(new Employee("p1first3", "last3", "@email", 3L));
        return mockList;
    }
}
