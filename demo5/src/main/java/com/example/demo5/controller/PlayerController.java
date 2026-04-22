package com.example.demo5.controller;

import com.example.demo5.dto.PlayerDTO;
import com.example.demo5.model.Player;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class PlayerController {
    // tao danh sach
    List<Player> list = new ArrayList<>(
            Arrays.asList(
                    new Player(1L,"Toni Kross" ,"CM" , 8 ,"data:image/jpeg;base64,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" ,LocalDate.of(1999,8,8))
            )
    );


    // hien thi
    @GetMapping
    public String renderList(Model model){
        model.addAttribute("players",list);
        return "home";
    }

    // chuyen sangc trang them
    @GetMapping("/view-add")
    public String formAdd(
            Model model
    ){
        model.addAttribute("playerDTO" , new PlayerDTO());
        return "form-add";
    }

    // nut buttom
    @PostMapping("/handle-add")
    public String handleAdd(
            @Valid@ModelAttribute(name = "playerDTO") PlayerDTO playerDTO,
            BindingResult br,
            Model model
    ){
        if (br.hasErrors()){
            model.addAttribute("playerDTO",playerDTO);
            return "form-add";
        }
        Player newPlayer = new Player(
                playerDTO.getId(),
                playerDTO.getName(),
                playerDTO.getPositio(),
                playerDTO.getJerseyNumber(),
                uploadFile(playerDTO.getAvatar()),
                playerDTO.getBirthDay()
        );
        list.add(newPlayer);
        return "redirect:/";
    }
    public String uploadFile(MultipartFile file) {
            String path = "C:\\Users\\loc\\OneDrive\\Máy tính\\Java Web\\demo5\\src\\main\\webapp\\images";

            if(file.isEmpty()) {
                return "";
            }

            String fileName = file.getOriginalFilename();

            File convertFile = new File(path + "\\" + fileName);

            try {
                file.transferTo(convertFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "/images/" + fileName;

        }


        // xoa
    @GetMapping("/delete/{id}")
    public String deleteID(
            @PathVariable(name = "id") Long id
    ){
        list.removeIf(p -> p.getId().equals(id));
        return "redirect:/";
    }

    // sua
    // lay id va chuyen sang trang sua
    @GetMapping("/update/{id}")
    public String viewUpdate(
            @PathVariable(name = "id") Long id,
            Model model
    ){
        Player player = list.stream()
                .filter(p ->p.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("playerDTO",player);
        return "form-update";
    }

    @PostMapping("/handle-update")
    public String handleUpdate(
            @ModelAttribute(name = "playerDTO") PlayerDTO pDTO
    ){
        for (Player p : list){
            if (p.getId().equals(pDTO.getId())){
                p.setName(pDTO.getName());
                p.setPositio(pDTO.getPositio());
                p.setJerseyNumber(pDTO.getJerseyNumber());
                p.setAvatar(pDTO.getAvatar().isEmpty() ? p.getAvatar() : uploadFile(pDTO.getAvatar()));
                p.setBirthDay(pDTO.getBirthDay());
            }

        }
        return "redirect:/";
    }
}
