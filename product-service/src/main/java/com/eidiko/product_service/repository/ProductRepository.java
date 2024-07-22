package com.eidiko.product_service.repository;

import com.eidiko.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product , Long> {

 Product findByProdName(String name) ;

    Product deleteById(long id);
}
