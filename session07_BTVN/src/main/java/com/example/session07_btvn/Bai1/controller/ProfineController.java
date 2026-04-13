package com.example.session07_btvn.Bai1.controller;

import com.example.session07_btvn.Bai1.model.RestaurantProfile;
import com.example.session07_btvn.Bai1.repository.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfineController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("profile" , profileService.getAll());
        return "home";
    }


    @PostMapping("/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        profileService.uploadProfile(profile);
        return "success";
    }
}
