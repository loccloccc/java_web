package com.example.demo10.controller;


import com.example.demo10.model.Product;
import com.example.demo10.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public String findAll(
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable,
            @RequestParam(name = "search", defaultValue = "") String search,
            Model model
    ) {
        Page<Product> products = productService.searchByName(search,pageable);

        int pageSize = products.getSize();
        int totalPages = products.getTotalPages();
        int current = products.getNumber();
        List<Product> list = products.getContent();

        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("current", current);
        model.addAttribute("products", list);
        model.addAttribute("search", search);

        return "home";
    }
}