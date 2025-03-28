package com.project.shopapp.service;

import java.util.List;

import com.project.shopapp.dto.OrderDTO;
import com.project.shopapp.exception.DataNotFoundException;
import com.project.shopapp.model.Order;

public interface IOrderService {
    Order createOrder(OrderDTO orderDTO) throws Exception;

    Order getOrder(Long id);

    Order updateOrder(Long id, OrderDTO orderDTO) throws DataNotFoundException;

    void deleteOrder(Long id);

    List<Order> findByUserId(Long userId);
}
