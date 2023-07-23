package service;

import com.example.springlist.exceptions.EmployeeAlreadyAddedException;
import com.example.springlist.exceptions.EmployeeNotFoundException;
import com.example.springlist.exceptions.EmployeeStorageIsFullException;
import dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEES_MAX_SIZE = 15;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String name, String lastName) {
        if (employees.size() == EMPLOYEES_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");
        }
        Employee employee = new Employee(name, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public List<Employee> findAll(){
        return employees;
    }

}
