package com.example.session08_demo.controller;

import com.example.session08_demo.dto.PersonDTO;
import com.example.session08_demo.model.Gender;
import com.example.session08_demo.model.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping
public class PersonController {
    public static List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(
                            1L,
                            "Duong Duc Loc",
                            Gender.FEMALE ,
                            LocalDate.of(2006,5,25) ,
                            20 ,
                            "loc@gmail.com")
            )
    );

    @GetMapping
    public String home(Model model){
        model.addAttribute("persons",personList);
        return "person-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){
        // gui sang view 1 du lieu rong
        model.addAttribute("personDTO" , new PersonDTO());
        return "person-form";
    }


    // them @Valid de kich hoat validate
    // va doi tuong BindingResult de kiem tra co loi hay khong
    @PostMapping("/handle-submit")
    public String handleSubmit(
            @Valid
            @ModelAttribute(name = "personDTO") PersonDTO personDTO ,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()){
            // gui lai giu lieu cu khi bi loi
            model.addAttribute("personDTO", personDTO);
            return "person-form";
        }
        // chuyen doi tu DTO sang model
        Person newPerson = new Person(
                personDTO.getId(),
                personDTO.getName(),
                personDTO.getGender(),
                personDTO.getDateOfBirth(),
                personDTO.getAge(),
                personDTO .getEmail()
        );
       personList.add(newPerson);
       return "redirect:/";
    }

    @GetMapping("/view-edit/{id}")
    public String viewEdit(
            @PathVariable(name = "id") Long editID,
            Model model
    ){
        // 1 . tìm được id cần sủa
        Person person = personList.stream()
                .filter(p -> p.getId().equals(editID))
                .findFirst().orElse(null);

        model.addAttribute("personDTO",person);
        return "person-form-edit";

    }

    @PostMapping("handle-update")
    public String handleUpdate(
            @ModelAttribute(name = "personDTO") PersonDTO personDTO
    ){

        for (Person p : personList){
            if(p.getId().equals(personDTO.getId())){
                p.setName(personDTO.getName());
                p.setAge(personDTO.getAge());
                p.setDateOfBirth(personDTO.getDateOfBirth());
                p.setGender(personDTO.getGender());
                p.setEmail(personDTO.getEmail());
            }
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(
            @ModelAttribute(name = "personDTO") PersonDTO personDTO
    ){
        personList.removeIf(p -> p.getId().equals(personDTO.getId()));

        return "redirect:/";
    }
}
