package com.example.session10.controller;


import com.example.session10.dto.TaskDTO;
import com.example.session10.model.Priority;
import com.example.session10.model.TaskItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping
public class TaskController {
    List<TaskItem> list = new ArrayList<>(
            Arrays.asList(
                    new TaskItem("TI1" , "Giao dien web home" , LocalDate.of(2026,5,5) , Priority.MEDIUM),
                    new TaskItem("TI2" , "Giao dien web dang ki" , LocalDate.of(2026,5,1) , Priority.LOW),
                    new TaskItem("TI3" , "Giao dien web dang nhap" , LocalDate.of(2026,5,1) , Priority.HIGH)
            )
    );

    @GetMapping
    public String home(Model model){
        model.addAttribute("task",list);
        return "task-list";
    }

    @GetMapping("view-add")
    public String taskForm(Model model, TaskDTO taskDTO){
        model.addAttribute("taskDTO",new TaskDTO());
        return "task-form";
    }

    @PostMapping("/handle")
    public String handleSubmit(
            @Valid @ModelAttribute(name = "taskDTO") TaskDTO taskDTO,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()){
            model.addAttribute("taskDTO",taskDTO);
            return "task-form";
        }
        TaskItem newTask = new TaskItem(
                taskDTO.getId(),
                taskDTO.getName(),
                taskDTO.getDeadline(),
                taskDTO.getPriority()
        );
        list.add(newTask);
        return "redirect:/";
    }
}

