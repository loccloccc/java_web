package org.example.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.service.CategoryService;
import org.example.ecommerce.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Long categoryId,
                       @RequestParam(required = false) Double minPrice,
                       @RequestParam(required = false) Double maxPrice,
                       @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("products", productService.search(name, categoryId, minPrice, maxPrice, PageRequest.of(page, 8)));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "client/home";
    }

    @GetMapping("/admin/products")
    public String adminList(Model model) {
        model.addAttribute("products", productService.search(null, null, null, null, PageRequest.of(0, 100)));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "admin/product-list";
    }

    @PostMapping("/admin/products/save")
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.search(null, null, null, null, PageRequest.of(0, 100)));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product-list";
    }

    @PostMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }
}