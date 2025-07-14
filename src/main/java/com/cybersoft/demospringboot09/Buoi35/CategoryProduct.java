package com.cybersoft.demospringboot09.Buoi35;

import java.util.List;

public class CategoryProduct {
    String tieuDe;
    List<Product> products;

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CategoryProduct(String tieuDe, List<Product> products) {
        this.tieuDe = tieuDe;
        this.products = products;
    }
}
