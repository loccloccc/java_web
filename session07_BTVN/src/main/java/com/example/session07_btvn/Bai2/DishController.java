package com.example.session07_btvn.Bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    @GetMapping("/add")
    public String showAddForm(
            Model model
    ) {
        List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
        model.addAttribute("categories", categories);
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(
            @ModelAttribute(name = "categories") Dish dish , Model model
    ) {
        List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage(
            @ModelAttribute(name = "categories") Dish dish ,
            Model model) {
        List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
        model.addAttribute("categories", categories);

        return "dish-search";
    }
}
