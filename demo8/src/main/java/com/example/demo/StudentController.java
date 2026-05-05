package com.example.demo;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public String index(
            @PageableDefault(page = 0,size=3,sort = "id",direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(value = "search" , required = false , defaultValue = "") String search,
            Model model){
        Page<Student> studentPage = studentService.findByName(search,pageable);
        model.addAttribute("studentPage",studentPage);
        model.addAttribute("search",search);
        return "home";
    }
}
