package com.store.service;

import com.store.model.ProductModel;

import java.util.List;

public interface ProductServiceIf {

    ProductModel saveUser(ProductModel user);

    ProductModel findById(long id);

    public List<ProductModel> getUserAll();

    ProductModel updateById(long id, ProductModel userInfo);

    void deleteById(long id);
}
