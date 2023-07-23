package service;

import dto.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee addEmployee(String name, String lastName);

    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    List<Employee> findAll();
}
