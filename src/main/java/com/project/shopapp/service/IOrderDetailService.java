package com.project.shopapp.service;

import java.util.List;

import com.project.shopapp.dto.OrderDetailDTO;
import com.project.shopapp.exception.DataNotFoundException;
import com.project.shopapp.model.OrderDetail;

public interface IOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception;

    OrderDetail getOrderDetail(Long id) throws DataNotFoundException;

    OrderDetail updateOrderDetail(Long id, OrderDetailDTO newOrderDetailData) throws DataNotFoundException;

    void deleteById(Long id);

    List<OrderDetail> findByOrderId(Long orderId);
}
