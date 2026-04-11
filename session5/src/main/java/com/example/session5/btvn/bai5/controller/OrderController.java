package com.example.session5.btvn.bai5.controller;


import com.example.session5.btvn.bai5.model.OrderItem;
import com.example.session5.btvn.bai5.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/bai5/order")
    public String orderPage(Model model) {

        List<OrderItem> orders = service.getOrders();
        double total = service.calculateTotal(orders);

        model.addAttribute("orders", orders);
        model.addAttribute("total", total);

        return "order";
    }
}
