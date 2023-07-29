package service;

import dto.Employee;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    Employee addEmployee(String name, String lastName, int department, int salary);


    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    Collection<Employee> findAll();
}
