package com.example.artwork_management.controller;

import com.example.artwork_management.model.Artwork;
import com.example.artwork_management.service.IArtwork;
import com.example.artwork_management.service.ICategoryService;
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
@RequestMapping("")
@RequiredArgsConstructor
public class ArtworkController {
    private final ICategoryService categoryService;
    private final IArtwork iArtwork;

    @GetMapping("")
    public String homeCategory(
            @PageableDefault(page = 0 , size = 5 , sort = "id" , direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(name = "search" , required = false,defaultValue = "") String seach,
            Model model
            ){
        Page<Artwork> artworks = iArtwork.getArtworks(seach, pageable);
        model.addAttribute("artworks", artworks);
        model.addAttribute("search", seach);
        return "home";
    }

}
