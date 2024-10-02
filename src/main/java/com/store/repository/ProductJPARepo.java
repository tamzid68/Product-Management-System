package com.store.repository;

import com.store.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepo extends JpaRepository<ProductModel, Long> {
}
