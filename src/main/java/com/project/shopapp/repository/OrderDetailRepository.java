package com.project.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {}
