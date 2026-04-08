package com.restaurant.Bai5.service;

import com.restaurant.Bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public String createOrder() {
        return "Tao don hang thanh cong";
    }

    public String deleteOrder(Long id) {
        return "Da huy don hang " + id;
    }
}
