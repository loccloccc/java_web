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
                    new Person(1,"Nguyen Van A",21,true,"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAACWCAMAAADABGUuAAAABlBMVEX////IEC5cagsYAAAAyklEQVR4nO3ZsQ3DABADMXv/pbOBy0dw4k0g1nqe097Pbrcch46Ojo5eDR0dHR29Gjo6Ojp6NXR0dHT0aujo6Ojo1dDR0dHRq6Gjo6OjV0NHR0dHr4aOjo6OXg0dHR39nP49phz6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLLdP/6dc9HnMbOjo6Ono1dHR0dPRq6Ojo6OjV0NHR0dGroaOjo6NXQ0dHR0evho6Ojo5eDR0dHR29Gjo6Ojp6NXR0dPRr+g++KStdDXbt2QAAAABJRU5ErkJggg=="),
                    new Person(2,"Nguyen Van B",21,true,"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAACWCAMAAADABGUuAAAABlBMVEX////IEC5cagsYAAAAyklEQVR4nO3ZsQ3DABADMXv/pbOBy0dw4k0g1nqe097Pbrcch46Ojo5eDR0dHR29Gjo6Ojp6NXR0dHT0aujo6Ojo1dDR0dHRq6Gjo6OjV0NHR0dHr4aOjo6OXg0dHR39nP49phz6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLLdP/6dc9HnMbOjo6Ono1dHR0dPRq6Ojo6OjV0NHR0dGroaOjo6NXQ0dHR0evho6Ojo5eDR0dHR29Gjo6Ojp6NXR0dPRr+g++KStdDXbt2QAAAABJRU5ErkJggg=="),
                    new Person(3,"Nguyen Van C",21,false,"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAACWCAMAAADABGUuAAAABlBMVEX////IEC5cagsYAAAAyklEQVR4nO3ZsQ3DABADMXv/pbOBy0dw4k0g1nqe097Pbrcch46Ojo5eDR0dHR29Gjo6Ojp6NXR0dHT0aujo6Ojo1dDR0dHRq6Gjo6OjV0NHR0dHr4aOjo6OXg0dHR39nP49phz6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLLdP/6dc9HnMbOjo6Ono1dHR0dPRq6Ojo6OjV0NHR0dGroaOjo6NXQ0dHR0evho6Ojo5eDR0dHR29Gjo6Ojp6NXR0dPRr+g++KStdDXbt2QAAAABJRU5ErkJggg=="),
                    new Person(4,"Nguyen Van D",21,true,"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAACWCAMAAADABGUuAAAABlBMVEX////IEC5cagsYAAAAyklEQVR4nO3ZsQ3DABADMXv/pbOBy0dw4k0g1nqe097Pbrcch46Ojo5eDR0dHR29Gjo6Ojp6NXR0dHT0aujo6Ojo1dDR0dHRq6Gjo6OjV0NHR0dHr4aOjo6OXg0dHR39nP49phz6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLoS+Gvhj6YuiLLdP/6dc9HnMbOjo6Ono1dHR0dPRq6Ojo6OjV0NHR0dGroaOjo6NXQ0dHR0evho6Ojo5eDR0dHR29Gjo6Ojp6NXR0dPRr+g++KStdDXbt2QAAAABJRU5ErkJggg==")

            )
    );

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("person",list);
        return "home";
    }
}
