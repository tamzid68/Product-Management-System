package com.hms.service;

import com.hms.model.ProductModel;
import com.hms.repository.UserJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceIf {
    @Autowired
    UserJPARepo userRepo;

    public List<ProductModel> getUserAll() {
        return userRepo.findAll();
    }

    @Override//add all new product
    public ProductModel saveUser(ProductModel user) {

        return userRepo.save(user);
    }

    @Override
    public ProductModel findById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public ProductModel updateById(long id, ProductModel userInfo) {
        ProductModel user = userRepo.findById(id).orElseThrow();
        user.setName(userInfo.getName());
        //user.setAddress(userInfo.getAddress());
        return userRepo.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }
}
