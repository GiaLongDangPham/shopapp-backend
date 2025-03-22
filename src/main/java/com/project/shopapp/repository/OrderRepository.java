package com.project.shopapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Tìm các đơn hàng của 1 user nào đó
    List<Order> findByUserId(Long userId);
}
