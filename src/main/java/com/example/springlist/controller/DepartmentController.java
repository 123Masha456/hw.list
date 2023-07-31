package com.example.springlist.controller;

import com.example.springlist.dto.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springlist.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryEmployee(@RequestParam int department) {
        return departmentService.findMaxSalaryEmployee(department);
    }
    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryEmployee(@RequestParam int department){
        return departmentService.findMinSalaryEmployee(department);
    }
    @GetMapping(path = "/all")
    public Collection<Employee> getAll(@RequestParam int department){
        return departmentService.getAll(department);
    }
    @GetMapping(path = "/allinDepartment")
    public Map<Integer, List<Employee>> getAllGroupingBy(){
    return departmentService.getAllGroupingBy();
    }
}

