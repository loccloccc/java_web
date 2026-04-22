package com.example.session12_demo2.controller;


import com.example.session12_demo2.dto.StudentDTO;
import com.example.session12_demo2.model.Student;
import com.example.session12_demo2.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {

    private final StudentService studentService;
    // phuong thuc tra ve view home
    @GetMapping
    public String home(Model model){
        model.addAttribute("listStudent",studentService.findAll());
        return "home";
    }


    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("studentDTO",new StudentDTO());
        return "view-add";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(
            @Valid @ModelAttribute(name = "studentDTO") StudentDTO studentDTO,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()){
            model.addAttribute("studentDTO" , studentDTO);
            return "view-add";
        }
        studentService.addStudent(studentDTO);
        return "redirect:/";

    }



}
