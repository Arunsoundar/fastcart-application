package com.inventory.fastcart.service;

import com.inventory.fastcart.modeldetails.Product;
import com.inventory.fastcart.modeldetails.Vendor;
import com.inventory.fastcart.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    public final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    public List<Vendor> getAllVendor()
    {
        return vendorRepository.findAll();
    }
    public Optional<Vendor> getVendorByID (Long id)
    {
        return vendorRepository.findById(id);
    }
    public Vendor createVendor (Vendor vendor)
    {
        return vendorRepository.save(vendor);
    }
    public void deleteVendor(Long id)
    {
        vendorRepository.deleteById(id);
    }
    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        Optional<Vendor> existingVendor = vendorRepository.findById(id);

        if (existingVendor.isPresent()) {
            Vendor vendor = existingVendor.get();
            vendor.setName(updatedVendor.getName());
            vendor.setEmail(updatedVendor.getEmail());
            vendor.setNumber(updatedVendor.getNumber());
            return vendorRepository.save(vendor);
        } else {
            throw new RuntimeException("Vendor not found with ID: " + id);
        }
    }


}
