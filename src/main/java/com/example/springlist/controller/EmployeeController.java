package com.example.springlist.controller;

import com.example.springlist.dto.Employee;
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
        return employeeService.addEmployee(name, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.removeEmployee(name, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.findEmployee(name, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}
