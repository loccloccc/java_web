package com.example.session5.btvn.bai5.repository;


import com.example.session5.btvn.bai5.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

    public List<OrderItem> getMockOrders() {
        return Arrays.asList(
                new OrderItem(1, "Phở bò", 50000, 2),
                new OrderItem(2, "Bún chả", 45000, 1)
        );
    }
}
