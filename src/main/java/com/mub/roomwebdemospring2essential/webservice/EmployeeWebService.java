package com.mub.roomwebdemospring2essential.webservice;

import com.mub.roomwebdemospring2essential.models.Employee;
import com.mub.roomwebdemospring2essential.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeWebService {

    private final EmployeeService employeeService;

    public EmployeeWebService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }
}
