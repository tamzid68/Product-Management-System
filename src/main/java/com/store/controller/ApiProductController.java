package com.store.controller;

import com.store.model.ProductModel;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add_product")
    public ProductModel saveProduct(@RequestBody ProductModel product){

        return productService.saveProduct(product);
    }

    @GetMapping(value = "/get_product")
    public List<ProductModel> showAllProduct(){
        return productService.getUserAll();
    }

    @PutMapping(value = "/update/{id}")
    public ProductModel updateById(@PathVariable long id, @RequestBody ProductModel userInfo) {
        return productService.updateById(id, userInfo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteById(id);
    }

}
