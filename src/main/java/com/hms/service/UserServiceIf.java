package com.hms.service;

import com.hms.model.Product;

import java.util.List;

public interface UserServiceIf {

    Product saveUser(Product user);

    Product findById(long id);

    public List<Product> getUserAll();

    Product updateById(long id, Product userInfo);

    void deleteById(long id);
}
