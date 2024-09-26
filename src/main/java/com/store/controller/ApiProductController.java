package com.store.controller;

import com.store.model.ProductModel;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add_product")
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return productService.saveUser(product);
    }
}
