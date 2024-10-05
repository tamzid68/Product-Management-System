package com.store.service;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import com.store.repository.ProductJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceIf {
    @Autowired
    ProductJPARepo productJPARepo;

    public List<ProductModel> getAllProduct() {
        return productJPARepo.findAll();
    }

    @Override//add all new product
    public ProductModel saveProduct(ProductModel user) {

        return productJPARepo.save(user);
    }

    @Override
    public void saveProductData(ProductDtoModel productDtoModel, ProductModel product) {
        // Set product details from the DTO
        product.setName(productDtoModel.getName());
        product.setBrand(productDtoModel.getBrand());
        product.setCategory(productDtoModel.getCategory());
        product.setPrice(productDtoModel.getPrice());
        product.setDescription(productDtoModel.getDescription());

        // Save product to the database
        productJPARepo.save(product);
    }

    @Override // Convert ProductModel to ProductDtoModel
    public ProductDtoModel convertToDto(ProductModel product) {
        ProductDtoModel productDto = new ProductDtoModel();
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        // If there's an image or other fields in ProductDtoModel, add them here as well
        return productDto;
    }


    @Override
    public void updateProductDetails(ProductModel product, ProductDtoModel productDto) {
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
    }


    @Override
    public ProductModel findById(long id) {

        return productJPARepo.findById(id).get();
    }

    @Override
    public ProductModel updateById(long id, ProductModel userInfo) {
        ProductModel user = productJPARepo.findById(id).orElseThrow();
        user.setName(userInfo.getName());
        //user.setAddress(userInfo.getAddress());
        return productJPARepo.save(user);
    }

    @Override
    public void deleteById(long id) {

        productJPARepo.deleteById(id);
    }
}
