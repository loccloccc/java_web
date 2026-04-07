package com.example.session03.Controller;

import com.example.session03.Model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import java.util.List;


@Controller

@RequestMapping("/employees")
public class EmployeeController {


    @GetMapping
    public String employees(HttpServletRequest request) {
        List<Employee> employee_list = new ArrayList<>();

        employee_list.add(new Employee(1,"Le Trung Chien","1",20000.0));
        employee_list.add(new Employee(2,"Le Trung Chien1","2",900.0));
        employee_list.add(new Employee(3,"Le Trung Chien2","3",20000.0));
        employee_list.add(new Employee(4,"Le Trung Chien3","4",100.0));

        request.setAttribute("employee_list", employee_list);
        return "employee-list";
    }



}