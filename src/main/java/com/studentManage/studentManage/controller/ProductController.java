package com.studentManage.studentManage.controller;

import com.studentManage.studentManage.DTO.ProductDTO;
import com.studentManage.studentManage.entity.Product;
import com.studentManage.studentManage.mapper.ProductMapper;
import com.studentManage.studentManage.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productServices.getAllProducts());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServices.getProductById(id));
    }

    @PostMapping
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productServices.createProduct(productDTO);
        ProductDTO productResponseDTO = ProductMapper.toDTO(product);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        // Assuming the update logic is handled in the service
        Product product = productServices.updateProduct(id, productDTO);
        ProductDTO productResponseDTO = ProductMapper.toDTO(product);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productServices.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    ResponseEntity<List<ProductDTO>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ProductDTO> productPage = productServices.searchProducts(name, page, size);
        return ResponseEntity.ok(productPage);
    }

    @GetMapping("/category/{id_category}")
    ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long id_category) {
        List<ProductDTO> products = productServices.getProductsByCategory(id_category);
        return ResponseEntity.ok(products);
    }
}
