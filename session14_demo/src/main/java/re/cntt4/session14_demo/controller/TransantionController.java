package re.cntt4.session14_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.cntt4.session14_demo.repository.TransantionRepository;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TransantionController {
    private final TransantionRepository transantionRepository;

    @GetMapping
    public String viewBanking(){


        return "banking";
    }
}
