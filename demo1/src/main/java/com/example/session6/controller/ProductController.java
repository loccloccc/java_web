package com.example.session6.controller;

import com.example.session6.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping
public class ProductController {
    List<Product> list = new ArrayList<>(
            Arrays.asList(
                    new Product(1,"Tui sach",300000,25,true),
                    new Product(2,"Giay adidas",210000,25,true),
                    new Product(3,"Ao phong",330000,25,false),
                    new Product(4,"Dien thoai",11300000,25,true),
                    new Product(5,"Sach vo",4300000,25,false)
            )
    );

    @GetMapping("/")
    public String productList(Model model){
        model.addAttribute("product",list);
        return "product-render";
    }
}
