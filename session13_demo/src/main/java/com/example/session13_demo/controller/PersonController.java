package com.example.session13_demo.controller;

import com.example.session13_demo.model.Person;
import com.example.session13_demo.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PersonController {

    // ap dung DI va nguyen ly solid - d
    public final IPersonRepository personRepository;

    @GetMapping
    public String home(Model model){
        model.addAttribute("psersons",personRepository.getAll());
        return "person-list";
    }

    @GetMapping("/add")
    public String viewAdd(
            Model model
    ){
        model.addAttribute("person",new Person());
        return "from-add";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute(name = "person") Person person
    ){
        personRepository.save(person);
        return "redirect:/";
    }
}
