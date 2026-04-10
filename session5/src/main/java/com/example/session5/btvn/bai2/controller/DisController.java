package com.example.session5.btvn.bai2.controller;

import com.example.session5.btvn.bai2.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping
public class DisController {
    List<Dish> dishList = new ArrayList<>(
            Arrays.asList(
                    new Dish(1,"Mi xao",35000,true),
                    new Dish(2,"Bun ca",45000,true),
                    new Dish(3,"Pho bo",50000,false),
                    new Dish(4,"Coca Cola",15000,true)
            )
    );

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("dish",dishList);
        return "dish-list";
    }

    @GetMapping("/update/{id}")
    public String updateById(
            @PathVariable(name = "id")
            int id , Model model){
        Dish dish = dishList.stream().filter(d -> d.getId() ==id).findFirst().orElse(null);
        model.addAttribute("update",dish);
        return "edit-dish";
    }

}
