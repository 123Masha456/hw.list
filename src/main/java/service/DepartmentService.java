package service;

import dto.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {
    Employee findMaxSalaryEmployee(int department);
    Employee findMinSalaryEmployee(int department);
    Collection<Employee> getAll(int department);
    Map<Integer, List<Employee>> getAllGroupingBy(int department);
}
