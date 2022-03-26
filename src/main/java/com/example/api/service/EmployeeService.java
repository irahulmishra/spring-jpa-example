package com.example.api.service;


import com.example.api.entity.Employee;
import com.example.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employee){
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);

    }

    public String deleteEmployee(long id){
        employeeRepository.deleteById(id);

        return "Employee removed with id : "+id;

    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setFirst_name(employee.getFirst_name());
        existingEmployee.setLast_name(employee.getLast_name());
        existingEmployee.setDept(employee.getDept());
        return employeeRepository.save(existingEmployee);

    }

}
