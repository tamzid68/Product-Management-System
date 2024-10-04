package com.store.controller;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import com.store.repository.ProductJPARepo;
import com.store.service.ProductServiceIf;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
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


    @GetMapping(value = "/user/{id}")
    public ProductModel finebyid(@PathVariable("id") long id) {
        return productService.findById(id);
    }

    @GetMapping({"","/"})
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

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute ProductDtoModel productDtoModel, BindingResult result) {
        if (productDtoModel.getImageFile().isEmpty()) {
            result.addError(new FieldError("productDto", "imageFile", "The image file is required"));
        }
        // Check for validation errors
        if (result.hasErrors()) {
            return "/products/createProduct";
        }
        // Create a new ProductModel instance here, for each request
        ProductModel product = new ProductModel();

        // Save the image and populate product data
        saveImageFile(productDtoModel, product);
        getDatafromFont(productDtoModel, product);

        return "redirect:/products";
    }
        // Updated saveImageFile method
        private void saveImageFile(ProductDtoModel productDtoModel, ProductModel product) {
            MultipartFile image = productDtoModel.getImageFile();
            Date createdAt = new Date();
            String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

            try {
                String uploadDir = "public/images";
                Path uploadPath = Paths.get(uploadDir);

                // Ensure the upload directory exists
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath); // Create the directory if it doesn't exist
                }

                // Save the file
                try (InputStream inputStream = image.getInputStream()) {
                    Path filePath = uploadPath.resolve(storageFileName); // Resolve to get the full file path
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING); // Copy the file
                }

                // Set file-related properties in the Product model
                product.setImageFileName(storageFileName);
                product.setCreatedAt(createdAt);

            } catch (IOException ex) {
                // Log error and add meaningful output
                System.err.println("File upload failed: " + ex.getMessage());
                // Optionally, you can set an error flag in the model or handle it appropriately.
            }
        }

    // Updated getDatafromFont method
    private void getDatafromFont(ProductDtoModel productDtoModel, ProductModel product) {

        product.setName(productDtoModel.getName());
        product.setBrand(productDtoModel.getBrand());
        product.setCategory(productDtoModel.getCategory());
        product.setPrice(productDtoModel.getPrice());
        product.setDescription(productDtoModel.getDescription());

        productService.saveUser(product);
    }


/*   @GetMapping(value = "/edit")
    public String showEditPage(Model model, @RequestParam long id) {
        try {
            product = productService.findById(id);
            model.addAttribute("product",product);

            ProductDtoModel productDtoModel = new ProductDtoModel();

            productDtoModel.setName(product.getName());
            productDtoModel.setBrand(product.getBrand());
            productDtoModel.setCategory(product.getCategory());
            productDtoModel.setPrice(product.getPrice());
            productDtoModel.setDescription(product.getDescription());

            model.addAttribute("productDto",productDtoModel);

        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            return "redirect:/products";
        }
        return "products/EditProduct";
    }*/

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable long id) {
        productService.deleteById(id);
    }


    //localhost:3306/myStory?createDatabaseIfNotExist=true
}
