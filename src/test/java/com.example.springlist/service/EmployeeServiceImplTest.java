package com.example.springlist.service;

import com.example.springlist.dto.Employee;
import com.example.springlist.exceptions.EmployeeAlreadyAddedException;
import com.example.springlist.exceptions.EmployeeNotFoundException;
import com.example.springlist.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;


import javax.lang.model.element.UnknownDirectiveException;
import javax.swing.text.html.StyleSheet;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee
            ("IVANOV", "IVAN", 1, 40000);
    Employee employee1 = new Employee
            ("PETROV", "PETR", 1, 10000);
    Employee employee2 = new Employee
            ("ALEXEEV", "ALEX", 2, 20000);


    @Test
    void addEmployee_employeeNumberOverloaded_thrownException() {
        underTest.addEmployee(employee.getLastName(), employee.getName(),
                employee.getDepartment(), employee.getSalary());
        underTest.addEmployee(employee1.getLastName(), employee1.getName(),
                employee1.getDepartment(), employee1.getSalary());

        EmployeeStorageIsFullException ex =
                assertThrows(EmployeeStorageIsFullException.class,
                        () -> underTest.addEmployee(employee2.getLastName(), employee2.getName(),
                                employee2.getDepartment(), employee2.getSalary()));
        assertEquals("Превышен лимит количества сотрудников", ex.getMessage());
    }

    @Test
    void addEmployee_employeeIsAlreadyInMap_thrownException() {
        underTest.addEmployee(employee2.getLastName(), employee2.getName(),
                employee2.getDepartment(), employee2.getSalary());

        EmployeeAlreadyAddedException ex =
                assertThrows(EmployeeAlreadyAddedException.class,
                        () -> underTest.addEmployee(employee2.getLastName(), employee2.getName(),
                                employee2.getDepartment(), employee2.getSalary()));
        assertEquals("В коллекции уже есть такой сотрудник", ex.getMessage());
    }

    @Test
    void addEmployee_employeeAdded_employeeReturned() {
        underTest.addEmployee(employee.getLastName(), employee.getName(),
                employee.getDepartment(), employee.getSalary());
        assertTrue(underTest.findAll().contains(employee));
    }

    @Test
    void removeEmployee_employeeIsNotInMap_thrownException() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.removeEmployee(
                                employee.getName(),
                                employee.getLastName()));
        assertEquals("Сотрудник не найден", ex.getMessage());
    }

    @Test
    void removeEmployee_employeeIsInMap_employeeRemovedAndReturned() {
        underTest.addEmployee(employee.getLastName(), employee.getName(),
                employee.getDepartment(), employee.getSalary());
        Employee result = underTest.removeEmployee(employee.getLastName(),
                employee.getName());
        assertEquals(employee, result);
        assertFalse(underTest.findAll().contains(employee));
    }

    @Test
    void findEmployee_employeeIsNotInMap_thrownException() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.findEmployee(
                                employee.getName(),
                                employee.getLastName()));
        assertEquals("Сотрудник не найден", ex.getMessage());
    }

    @Test
    void findEmployee_employeeIsInMap_employeeFoundAndReturned() {
        underTest.addEmployee(employee.getLastName(), employee.getName(),
                employee.getDepartment(), employee.getSalary());
        Employee result = underTest.findEmployee(employee.getLastName(), employee.getName());
        assertEquals(employee, result);
    }

    @Test
    void findAll_allEmployeeInMap_returnedAllEmployees() {
        underTest.addEmployee(employee.getLastName(), employee.getName(),
                employee.getDepartment(), employee.getSalary());
        underTest.addEmployee(employee2.getLastName(), employee2.getName(),
                employee2.getDepartment(), employee2.getSalary());

        Collection<Employee> result = underTest.findAll();
        assertIterableEquals(List.of(employee, employee2), result);
        assertFalse(underTest.findAll().contains(Collections.emptyList()));
    }
}
