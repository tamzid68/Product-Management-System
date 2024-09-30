package com.store.controller;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add_product")
    public ProductModel saveProduct(@RequestBody ProductModel product){

        return productService.saveUser(product);
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
