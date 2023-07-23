package service;

import dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String name, String lastName);

    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    List<Employee> findAll();
}
