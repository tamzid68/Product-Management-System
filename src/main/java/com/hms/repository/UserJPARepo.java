package com.hms.repository;

import com.hms.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepo extends JpaRepository<ProductModel, Long> {
}
