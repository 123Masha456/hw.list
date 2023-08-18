package com.example.springlist.controller;

import com.example.springlist.dto.Employee;
import com.example.springlist.util.EmployeeNameValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springlist.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String name, @RequestParam String lastName,
                        @RequestParam int department, @RequestParam int salary) {
        EmployeeNameValidator.checkName(name, lastName);
        return employeeService.addEmployee(name, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastName) {
        EmployeeNameValidator.checkName(name, lastName);
        return employeeService.removeEmployee(name, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String name, @RequestParam String lastName) {
        EmployeeNameValidator.checkName(name, lastName);
        return employeeService.findEmployee(name, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}