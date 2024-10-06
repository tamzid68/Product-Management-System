package com.store.service;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;

import java.util.List;

public interface ProductServiceIf {

    ProductModel saveProduct(ProductModel user);

    void saveProductData(ProductDtoModel productDtoModel, ProductModel product);

    ProductDtoModel convertToDto(ProductModel product);

    void updateProductDetails(ProductModel product, ProductDtoModel productDto);

    ProductModel findById(long id);

    List<ProductModel> getAllProduct();

    //ProductModel updateById(long id, ProductModel userInfo);

    void deleteById(long id);
}
