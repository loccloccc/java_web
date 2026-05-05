package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class UserController {
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1,"A","A"),
                    new User(2,"B","B"),
                    new User(3,"C","C")
            )
    );

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "home";
    }
}
