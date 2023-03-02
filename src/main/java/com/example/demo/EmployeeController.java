package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }
        employee.setName(employeeDetails.getName());
        employee.setCity(employeeDetails.getCity());
        return employeeRepository.save(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
