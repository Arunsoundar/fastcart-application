package com.inventory.fastcart.repository;

import com.inventory.fastcart.modeldetails.Employee;
import com.inventory.fastcart.modeldetails.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);

}
