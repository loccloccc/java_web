package com.restaurant.Bai5.controller;


import com.restaurant.Bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/bai5/orders/{id}")
    public String getOrder(@PathVariable String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            return "ID don hang phai la mot so";
        }
    }

    @PostMapping("/bai5/orders")
    public String createOrder() {
        return orderService.createOrder();
    }

    @DeleteMapping("/bai5/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}