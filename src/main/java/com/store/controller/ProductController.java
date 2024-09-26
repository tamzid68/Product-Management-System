package com.store.controller;

import com.store.model.ProductModel;
import com.store.service.ProductServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceIf productService;


    @PostMapping(value = "/add")
    public ProductModel saveUser(@RequestBody ProductModel user) {

        return productService.saveUser(user);
    }

//    @PostMapping(value = "/user")
//    public String saveUser(@RequestParam String name, @RequestParam String address){
//        User object = new User();
//        object.setName(name);
//        object.setAddress(address);
//        userService.saveUser(object);
//        return "Saved";
//    }

    @GetMapping(value = "/user/{id}")
    public ProductModel finebyid(@PathVariable("id") long id) {
        return productService.findById(id);
    }

    @GetMapping(value="/getAll")
    public String getAllUser(Model model) {
        List<ProductModel> products = productService.getUserAll();
        model.addAttribute("productTale",products);
        return "products/ind";
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
