package com.store.service;

import com.store.model.ProductModel;
import com.store.repository.ProductJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mock.web.MockMultipartFile;
import java.io.FileInputStream;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Service
public class ApiProductService implements ApiProductServiceIf{

    @Autowired
    private ProductJPARepo productJPARepo;

    @Override
    public List<ProductModel> getAllProduct(){
        return productJPARepo.findAll();
    }

    @Override
    public ProductModel saveProduct(ProductModel product){
        return productJPARepo.save(product);
    }

    @Override
    public ProductModel findById(long id){
        return productJPARepo.findById(id).get();
    }

    @Override
    public ProductModel updateById(long id, ProductModel productInfo) {
        // Fetch the existing product from the database
        ProductModel existingProduct = productJPARepo.findById(id).orElseThrow(()->
                new RuntimeException("Product not found with id : "+id));

        // Check if userInfo contains non-null fields, if so, update those fields
        if(productInfo.getName() !=null && !productInfo.getName().isEmpty()){
            existingProduct.setName(productInfo.getName());
        }
        if(productInfo.getBrand() !=null && !productInfo.getBrand().isEmpty()){
            existingProduct.setBrand(productInfo.getBrand());
        }
        if(productInfo.getCategory() !=null && !productInfo.getCategory().isEmpty()){
            existingProduct.setCategory(productInfo.getCategory());
        }
        if(productInfo.getPrice() >0){
            existingProduct.setPrice(productInfo.getPrice());
        }
        if(productInfo.getDescription() !=null && !productInfo.getDescription().isEmpty()){
            existingProduct.setDescription(productInfo.getDescription());
        }

        return productJPARepo.save(existingProduct);
    }




    @Override
    public void deleteById(long id){
        productJPARepo.deleteById(id);
    }
}
