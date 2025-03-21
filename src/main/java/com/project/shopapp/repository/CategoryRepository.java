package com.project.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
