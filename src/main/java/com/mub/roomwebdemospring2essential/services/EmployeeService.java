package com.mub.roomwebdemospring2essential.services;

import com.mub.roomwebdemospring2essential.models.Employee;
import com.mub.roomwebdemospring2essential.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository roomRepository) {
        this.employeeRepository = roomRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

}
