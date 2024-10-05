package com.store.service;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import org.springframework.web.multipart.MultipartFile;

public interface ImageServiceIf {
    void saveImageFile(ProductDtoModel productDtoModel, ProductModel productModel);

    void updateImageFile(ProductModel product, MultipartFile imageFile);

    void deleteImageFile(String imageName);
}
