package com.restaurant.Bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @GetMapping("/bai4/products")
    public String getProducts(
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            ModelMap model
    ) {
        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tim kiem thanh cong");

        return "productList";
    }
}
