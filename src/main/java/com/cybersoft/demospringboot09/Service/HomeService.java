package com.cybersoft.demospringboot09.Service;

import com.cybersoft.demospringboot09.entity.CategoryProduct;
import com.cybersoft.demospringboot09.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    public List<CategoryProduct> getCategoryProducts() {
        List<Product> dsSanPham01 = List.of(
                new Product("https://picsum.photos/200/300", "Sản phẩm 1", 100000L, List.of("Smember giảm giá 93.000đ", "Không phí chuyển đổi trả góp 0%")),
                new Product("https://picsum.photos/200/300", "Sản phẩm 2", 200000L, List.of("Smember giảm giá 250.000đ", "Không phí chuyển đổi trả góp 0%"))
        );
        List<Product> dsSanPham02 = List.of(
                new Product("https://picsum.photos/200/300", "Sản phẩm 3", 300000L, List.of("Smember giảm giá 93.000đ", "Không phí chuyển đổi trả góp 10%")),
                new Product("https://picsum.photos/200/300", "Sản phẩm 4", 400000L, List.of("Smember giảm giá 250.000đ", "Không phí chuyển đổi trả góp 20%"))
        );
        List<CategoryProduct> dsDanhMuc = List.of(
                new CategoryProduct("Danh mục 1", dsSanPham01),
                new CategoryProduct("Danh mục 2", dsSanPham02)
        );
        return dsDanhMuc;
    }
}
