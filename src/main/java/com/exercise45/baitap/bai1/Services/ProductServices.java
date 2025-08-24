package com.exercise45.baitap.bai1.Services;

import com.exercise45.baitap.bai1.Entity.Product;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
