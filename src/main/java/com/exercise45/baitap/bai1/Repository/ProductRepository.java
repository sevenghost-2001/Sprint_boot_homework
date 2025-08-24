package com.exercise45.baitap.bai1.Repository;

import com.exercise45.baitap.bai1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
