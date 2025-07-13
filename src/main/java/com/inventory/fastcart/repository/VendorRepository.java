package com.inventory.fastcart.repository;

import com.inventory.fastcart.modeldetails.Product;
import com.inventory.fastcart.modeldetails.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository <Vendor, Long>{

}
