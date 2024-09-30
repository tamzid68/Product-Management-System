package com.store.controller;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import com.store.service.ProductServiceIf;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.nio.file.Paths;
import java.util.Date;
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

    @GetMapping(value = "/create")
    public String showCreatePage(Model model){
        System.out.println("test okay");
        model.addAttribute("productDto", new ProductDtoModel());
        return "products/createProduct";
    }

    @PostMapping("/newProduct")
    public String createProduct(@Valid @ModelAttribute ProductDtoModel productDtoModel, BindingResult result){
        if(productDtoModel.getImageFile().isEmpty()){
            result.addError(new FieldError("productDto", "imageFile" , "The image file is required"));
        }

        if(result.hasErrors()){
            return "products/createProduct";
        }
        //save image file
        MultipartFile image = productDtoModel.getImageFile();
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

        try{
            String uploadDir ="public/images";
            Path uploadPath = Paths.get(uploadDir);
        }catch (Exception ex){
            
        }

        return "redirect:/products";
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
