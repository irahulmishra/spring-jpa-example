package com.example.api;

import com.example.api.entity.Employee;
import com.example.api.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void updateEmployeeTest(){
        Employee employee = employeeRepository.findById(21L).get();
        employee.setDept("IT_3");
        Employee employeeUpdated = employeeRepository.save(employee);
        Assertions.assertThat(employeeUpdated.getDept()).isEqualTo("IT_3");




    }
}
