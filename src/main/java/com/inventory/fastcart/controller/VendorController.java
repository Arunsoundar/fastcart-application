package com.inventory.fastcart.controller;

import com.inventory.fastcart.modeldetails.Vendor;
import com.inventory.fastcart.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    public final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getAllVendors()
    {
        return vendorService.getAllVendor();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id){
      return vendorService.getVendorByID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor)
    {
        return vendorService.createVendor(vendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVendor(@PathVariable Long id)
    {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        try {
            Vendor vendor = vendorService.updateVendor(id, updatedVendor);
            return ResponseEntity.ok(vendor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
