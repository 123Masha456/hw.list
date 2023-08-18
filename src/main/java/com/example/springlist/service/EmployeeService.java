package com.example.springlist.service;

import com.example.springlist.dto.Employee;


import java.util.Collection;


public interface EmployeeService {
    Employee addEmployee(String name, String lastName, int department, int salary);

    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    Collection<Employee> findAll();
}
