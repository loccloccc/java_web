package com.example.session07.controller;


import com.example.session07.model.Student;
import com.example.session07.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String home(Model model){
        model.addAttribute("student",studentRepository.getAllStudent());
        return "home";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("student",new Student());
        return "form-add";
    }
    @PostMapping("/handle-add")
    public String handleAdd(@ModelAttribute(name = "student") Student student){
        studentRepository.addStudent(student);
        return "redirect:/";
    }
}
