package com.example.session5.btvn.bai5.sevice;


import com.example.session5.btvn.bai5.model.OrderItem;
import com.example.session5.btvn.bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<OrderItem> getOrders() {
        return repo.getMockOrders();
    }

    public double calculateTotal(List<OrderItem> list) {
        return list.stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }
}