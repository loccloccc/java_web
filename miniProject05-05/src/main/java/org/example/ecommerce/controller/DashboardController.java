package org.example.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.repository.OrderRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("totalRevenue", orderRepository.getTotalRevenue());
        model.addAttribute("topProducts", productRepository.getTopSellingProducts());
        return "admin/dashboard";
    }
}
