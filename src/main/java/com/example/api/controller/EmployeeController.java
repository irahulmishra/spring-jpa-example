package com.example.api.controller;



import com.example.api.entity.Employee;
import com.example.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/add-employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("/employee")
    public List<Employee> findAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);

    }

}
