package com.cybersoft.demospringboot09.controller;

import com.cybersoft.demospringboot09.Service.HomeService;
import com.cybersoft.demospringboot09.entity.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @PostMapping
    ResponseEntity<?> getHomePage() {
        List<CategoryProduct> categoryProducts = homeService.getCategoryProducts();
        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }
}
