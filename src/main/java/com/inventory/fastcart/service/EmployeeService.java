package com.inventory.fastcart.service;

import com.inventory.fastcart.modeldetails.Employee;
import com.inventory.fastcart.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeDetails()
    {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeFindByID (Long id)
    {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id )
    {
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setUsername(updatedEmployee.getUsername());
                    existingEmployee.setPassword(updatedEmployee.getPassword());
                    existingEmployee.setRole(updatedEmployee.getRole());
                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }




}
