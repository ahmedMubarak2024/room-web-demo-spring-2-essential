package com.mub.roomwebdemospring2essential.controllers;

import com.mub.roomwebdemospring2essential.models.Employee;
import com.mub.roomwebdemospring2essential.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showEmployees(Model model) {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        model.addAttribute("Employees", allEmployee);
        return "employeeListing";
    }
}
