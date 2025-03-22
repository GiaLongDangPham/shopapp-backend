package com.project.shopapp.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

    Page<Product> findAll(Pageable pageable); // phân trang
}
