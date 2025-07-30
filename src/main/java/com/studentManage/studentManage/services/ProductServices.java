package com.studentManage.studentManage.services;

import com.studentManage.studentManage.DTO.ProductDTO;
import com.studentManage.studentManage.entity.Product;

import java.util.List;

public interface ProductServices {

    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    Product createProduct(ProductDTO productDTO);
    Product updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    List<ProductDTO> searchProducts(String name, int page, int size);
    List<ProductDTO> getProductsByCategory(Long id_category);
}
