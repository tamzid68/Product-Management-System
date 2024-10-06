package com.store.service;

import com.store.model.ProductModel;

import java.util.List;

public interface ApiProductServiceIf {
    List<ProductModel> getAllProduct();

    ProductModel saveProduct(ProductModel product);

    ProductModel findById(long id);

    ProductModel updateById(long id, ProductModel userInfo);

    void deleteById(long id);
}
