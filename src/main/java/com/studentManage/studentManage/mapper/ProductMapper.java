package com.studentManage.studentManage.mapper;

import com.studentManage.studentManage.DTO.ProductDTO;
import com.studentManage.studentManage.entity.Category;
import com.studentManage.studentManage.entity.Product;
import com.studentManage.studentManage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        if (product == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            productDTO.setCategoryName(product.getCategory().getName());
        } else {
            productDTO.setCategoryName(null);
        }
        return productDTO;
    }
    public static Product toEntity(ProductDTO productDTO, Category category) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        // Assuming categoryName is used to set the category, you might need to adjust this based on your actual entity structure
        category.setName(productDTO.getCategoryName());
        product.setCategory(category);
        return product;
    }
}
