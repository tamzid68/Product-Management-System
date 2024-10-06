package com.store.controller;

import com.store.model.ProductModel;
import com.store.service.ApiProductServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ApiProductServiceIf productService;

    @GetMapping(value = "/get_product")
    public List<ProductModel> showAllProduct() {

        return productService.getAllProduct();
    }
    @PostMapping(value = "/add_product")
    public ProductModel saveProduct(@RequestBody ProductModel product) {

        return productService.saveProduct(product);
    }

    @GetMapping(value = "/getBy/{id}")
    public ProductModel getById(@PathVariable long id){
        return productService.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ProductModel updateById(@PathVariable long id, @RequestBody ProductModel product) {
        return productService.updateById(id, product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteById(id);
    }

}
