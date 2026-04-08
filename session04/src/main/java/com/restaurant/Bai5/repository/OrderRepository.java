package com.restaurant.Bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getOrderById(Long id) {
        return "Thong tin don hang " + id;
    }
}
