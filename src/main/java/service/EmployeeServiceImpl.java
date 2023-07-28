package service;

import com.example.springlist.exceptions.EmployeeAlreadyAddedException;
import com.example.springlist.exceptions.EmployeeNotFoundException;
import com.example.springlist.exceptions.EmployeeStorageIsFullException;
import dto.Employee;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private final Map<String, Employee> employeesMap;
    private static final int EMPLOYEES_MAX_SIZE = 15;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
        this.employeesMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String name, String lastName) {
        if (employeesMap.size() == EMPLOYEES_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }
        Employee employee = new Employee(name, lastName);
        String key = name + lastName;
        if (employees.contains(key)) {
            throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник");
        }
        employeesMap.put(key, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String lastName) {
        Employee employee = employeesMap.remove(name + lastName);
        if (employee  == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = employeesMap.get(name + lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll(){
        return employeesMap.values();
    }

}
