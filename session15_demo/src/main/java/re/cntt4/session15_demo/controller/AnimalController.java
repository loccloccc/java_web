package re.cntt4.session15_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.cntt4.session15_demo.service.IAnimalService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AnimalController {
    private final IAnimalService animalService;

    @GetMapping
    public String home(
            @RequestParam(name = "page" , defaultValue = "0") Integer page,
            @RequestParam(name = "sixe" , defaultValue = "3") Integer size,
            @RequestParam(name = "search",defaultValue = "") String search,
            Model model){
        // thong tin cua page<Animal> se tra ve rat nhieu
        model.addAttribute("animals",animalService.getAllAnimal(search,page,size));
        return "zoo";
    }
}
