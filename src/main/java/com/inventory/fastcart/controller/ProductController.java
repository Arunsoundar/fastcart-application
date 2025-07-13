package com.inventory.fastcart.controller;

import com.inventory.fastcart.modeldetails.Product;
import com.inventory.fastcart.modeldetails.Vendor;
import com.inventory.fastcart.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getproduct()
    {
       return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getByProductID (@PathVariable Long id)
    {
        return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createproduct (@RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            Product product = productService.updateProduct(id, updatedProduct);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



}

