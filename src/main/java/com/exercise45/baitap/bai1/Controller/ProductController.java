package com.exercise45.baitap.bai1.Controller;

import com.exercise45.baitap.bai1.Entity.Product;
import com.exercise45.baitap.bai1.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @GetMapping
    public ResponseEntity<?> getAllProducts() {

        return ResponseEntity.ok(productServices.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServices.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productServices.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product) {
        return ResponseEntity.ok(productServices.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productServices.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
