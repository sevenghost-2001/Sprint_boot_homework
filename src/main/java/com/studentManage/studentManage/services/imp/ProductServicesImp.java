package com.studentManage.studentManage.services.imp;

import com.studentManage.studentManage.DTO.CategoryDTO;
import com.studentManage.studentManage.DTO.ProductDTO;
import com.studentManage.studentManage.entity.Category;
import com.studentManage.studentManage.entity.Product;
import com.studentManage.studentManage.mapper.ProductMapper;
import com.studentManage.studentManage.repository.CateogryRepository;
import com.studentManage.studentManage.repository.ProductRepository;
import com.studentManage.studentManage.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImp implements ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CateogryRepository cateogryRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDTO).toList();
    }
    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElse(null);
    }
    @Override
    public Product createProduct(ProductDTO productDTO) {
        String categoryName = productDTO.getCategoryName();
        Optional<Category> categoryOpt = cateogryRepository.findByName(categoryName);
        if(categoryOpt.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        Category category = categoryOpt.get();
        Product product = ProductMapper.toEntity(productDTO, category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
        // Kiểm tra xem sản phẩm có tồn tại không
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        String categoryName = productDTO.getCategoryName();
        Optional<Category> categoryOpt = cateogryRepository.findByName(categoryName);
        if(categoryOpt.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        Category category = categoryOpt.get();
        // Cập nhật thông tin sản phẩm
        Product product = ProductMapper.toEntity(productDTO, category);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> searchProducts(String name, int page, int size) {
        Pageable pageable =  PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findByNameContainingIgnoreCase(name, pageable);
        return productPage.stream().map(ProductMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long id_category) {
        Optional<Category> categoryOpt = cateogryRepository.findById(id_category);
        if(categoryOpt.isEmpty()){
            throw new RuntimeException("Category not found");
        }
        Category category = categoryOpt.get();
        List<Product> products = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if (product.getCategory() != null && product.getCategory().equals(category)) {
                products.add(product);
            }
        }
        if(products != null && !products.isEmpty()) {
            return products.stream().map(ProductMapper::toDTO).toList();
        }
        return List.of();
    }


}
