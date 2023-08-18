package com.example.springlist.service;

import com.example.springlist.dto.Employee;
import com.example.springlist.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl underTest;
    Employee ivan = new Employee("IVANOV", "IVAN", 1, 20000);
    Employee petr = new Employee("PETROV", "PETR", 1, 30000);
    Employee klara = new Employee("KLAROVA", "KLARA", 2, 40000);
    Collection<Employee> employees;

    @BeforeEach
    void beforeEach() {
        employees = List.of(ivan, petr, klara);
    }

    @Test
    void findMaxSalaryEmployee_employeeFound_returnEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        Employee result = underTest.findMaxSalaryEmployee(1);
        assertEquals(petr, result);
    }

    @Test
    void findMaxSalaryEmployee_employeeNotFound_throwEmployeeNotFoundException() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.findMaxSalaryEmployee(1));
        assertEquals("Такой сотрудник не найден", ex.getMessage());
    }

    @Test
    void findMinSalaryEmployee_employeeFound_returnEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        Employee result = underTest.findMinSalaryEmployee(1);
        assertEquals(ivan, result);
    }

    @Test
    void findMinSalaryEmployee_employeeNotFound_returnEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.findMinSalaryEmployee(1));
        assertEquals("Такой сотрудник не найден", ex.getMessage());
    }

    @Test
    void getAllEmployeesInDepartment_employeesFound_returnAllEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);
        Collection<Employee> result = underTest.getAll(1);
        assertEquals(List.of(ivan, petr), result);
    }

    @Test
    void getAllGroupingByDepartment_employeesFound_returnEmployeesInEachDepartment() {
        when(employeeService.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> result = underTest.getAllGroupingBy();
        assertEquals(Map.of(1, List.of(ivan, petr), 2, List.of(klara)), result);
    }
}
