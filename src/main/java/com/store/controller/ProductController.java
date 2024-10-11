package com.store.controller;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import com.store.service.ImageService;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import org.aspectj.bridge.ISourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;
    private final ImageService imageService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService, ImageService imageService) {
        this.productService = productService;
        this.imageService = imageService;
    }


    @GetMapping({"", "/"})
    public String getAllUser(Model model) {
        List<ProductModel> products = productService.getAllProduct();
        model.addAttribute("productTale",products);
        return "products/ind";
    }

    //-----------------------------------------------------------------------------------//

    @GetMapping(value = "/create")
    public String showCreatePage(Model model){
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
        imageService.saveImageFile(productDtoModel, product);
        productService.saveProductData(productDtoModel, product);


        return "redirect:/products";
    }


    //-----------------------------------------------------------------------------------//

  @GetMapping(value = "/edit")
    public String showEditPage(Model model, @RequestParam long id) {
        try {
            ProductModel product = productService.findById(id);
            model.addAttribute("product",product);

            ProductDtoModel productDtoModel = productService.convertToDto(product);
            model.addAttribute("productDto",productDtoModel);

        } catch (Exception e) {
            log.error("Exception while fetching product with id {}: {}", id, e.getMessage());
            return "redirect:/products";
        }
        return "products/EditProduct";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @RequestParam long id,
                                @Valid @ModelAttribute ProductDtoModel productDto,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "products/EditProduct"; // Ensure the model is populated for the view
        }

        try {
            ProductModel product = productService.findById(id);
            model.addAttribute("product", product);

            imageService.updateImageFile(product, productDto.getImageFile());
            //handleImageUpdate(product, productDto.getImageFile());

            productService.updateProductDetails(product, productDto);
            //updateProductDetails(product, productDto);

            productService.saveProduct(product);
        } catch (Exception ex) {
            log.error("Error updating product with id " + id + ": " + ex.getMessage(), (ISourceLocation) ex);
        }
        return "redirect:/products";
    }


//-----------------------------------------------------------------------------------//

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam long id) {

        try {
            ProductModel product = productService.findById(id);
            imageService.deleteImageFile(product.getImageFileName());
            productService.deleteById(id);
        } catch (Exception ex) {
            log.error("Error deleting product with id {}: {}", id, ex.getMessage());
        }
        return "redirect:/products";
    }

    //localhost:3306/myStory?createDatabaseIfNotExist=true
}
