package com.hms.service;

import com.hms.model.ProductModel;

import java.util.List;

public interface UserServiceIf {

    ProductModel saveUser(ProductModel user);

    ProductModel findById(long id);

    public List<ProductModel> getUserAll();

    ProductModel updateById(long id, ProductModel userInfo);

    void deleteById(long id);
}
