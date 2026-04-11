package com.example.demo2.controller;

import com.example.demo2.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    List<Person> list = new ArrayList<>(
            Arrays.asList(
                    new Person(1,"Nguyen Van A",21,true),
                    new Person(2,"Nguyen Van B",21,true),
                    new Person(3,"Nguyen Van C",21,false),
                    new Person(4,"Nguyen Van D",21,true)

            )
    );

    @GetMapping("/")
    public String home(Model model){
        Person person = list.get(2);
        model.addAttribute("person",person);
        return "home";
    }
}
