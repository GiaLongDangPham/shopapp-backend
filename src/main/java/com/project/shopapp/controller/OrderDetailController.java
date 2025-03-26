package com.project.shopapp.controller;

import java.util.List;

import com.project.shopapp.component.LocalizationUtils;
import com.project.shopapp.util.MessageKeys;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.shopapp.dto.*;
import com.project.shopapp.exception.DataNotFoundException;
import com.project.shopapp.model.OrderDetail;
import com.project.shopapp.response.OrderDetailResponse;
import com.project.shopapp.service.IOrderDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/order_details")
@RequiredArgsConstructor
public class OrderDetailController {
    private final IOrderDetailService orderDetailService;
    private final ModelMapper modelMapper;
    private final LocalizationUtils localizationUtils;

    // Thêm mới 1 order detail
    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        try {
            OrderDetail newOrderDetail = orderDetailService.createOrderDetail(orderDetailDTO);

            OrderDetailResponse orderDetailResponse = modelMapper.map(newOrderDetail, OrderDetailResponse.class);
            orderDetailResponse.setId(newOrderDetail.getId());
            orderDetailResponse.setOrderId(newOrderDetail.getOrder().getId());
            orderDetailResponse.setProductId(newOrderDetail.getProduct().getId());

            return ResponseEntity.ok().body(orderDetailResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(@Valid @PathVariable("id") Long id) throws DataNotFoundException {
        OrderDetail orderDetail = orderDetailService.getOrderDetail(id);
        return ResponseEntity.ok().body(modelMapper.map(orderDetail, OrderDetailResponse.class));
    }
    // lấy ra danh sách các order_details của 1 order nào đó
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(@Valid @PathVariable("orderId") Long orderId) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        List<OrderDetailResponse> orderDetailResponses = orderDetails.stream()
                .map(orderDetail -> modelMapper.map(orderDetail, OrderDetailResponse.class))
                .toList();
        return ResponseEntity.ok(orderDetailResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Valid @PathVariable("id") Long id, @RequestBody OrderDetailDTO orderDetailDTO) {
        try {
            OrderDetail orderDetail = orderDetailService.updateOrderDetail(id, orderDetailDTO);
            return ResponseEntity.ok().body(modelMapper.map(orderDetail, OrderDetailResponse.class));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@Valid @PathVariable("id") Long id) {
        orderDetailService.deleteById(id);
        return ResponseEntity.ok().body(localizationUtils.getLocalizedMessage(MessageKeys.DELETE_ORDER_DETAIL_SUCCESSFULLY));
        // return ResponseEntity.noContent().build();
    }
}
