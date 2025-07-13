package com.inventory.fastcart.repository;

import com.inventory.fastcart.modeldetails.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
