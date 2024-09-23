package com.hms.service;

import com.hms.model.Product;
import com.hms.repository.UserJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceIf {
    @Autowired
    UserJPARepo userRepo;

    public List<Product> getUserAll() {
        return userRepo.findAll();
    }

    @Override//add all new product
    public Product saveUser(Product user) {

        return userRepo.save(user);
    }

    @Override
    public Product findById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Product updateById(long id, Product userInfo) {
        Product user = userRepo.findById(id).orElseThrow();
        user.setName(userInfo.getName());
        //user.setAddress(userInfo.getAddress());
        return userRepo.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }
}
