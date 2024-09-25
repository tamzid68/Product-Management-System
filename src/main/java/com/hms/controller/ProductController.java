package com.hms.controller;

import com.hms.model.ProductModel;
import com.hms.service.UserServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private UserServiceIf userService;


    @PostMapping(value = "/add_user")
    public ProductModel saveUser(@RequestBody ProductModel user) {

        return userService.saveUser(user);
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
        return userService.findById(id);
    }

    @GetMapping(value="/data")
    public String getAllUser(Model model) {
        List<ProductModel> products =userService.getUserAll();
        model.addAttribute("productTale",products);
        return "products/ind";
    }


    @PutMapping(value = "/update/{id}")
    public ProductModel updateById(@PathVariable long id, @RequestBody ProductModel userInfo) {
        return userService.updateById(id, userInfo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

}
