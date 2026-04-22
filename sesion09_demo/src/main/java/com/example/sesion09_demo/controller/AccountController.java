package com.example.sesion09_demo.controller;


import com.example.sesion09_demo.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
// co "s" thi tu dong luu gia tri
@SessionAttributes("dataLogin")
public class AccountController {

    List<Account> accounts = new ArrayList<>(
            Arrays.asList(
                    new Account(1L,"Duong Duc Loc","locbeo","123456")
            )
    );

    @GetMapping
    public String home(){
        return "home";
    }

    // tao ra 1 duong dan cho login
    @GetMapping("/login")
    public String loginForm(Model model){
    model.addAttribute("dataLogin" , new Account());
        return "login-form";
    }

    // nut submit
    @PostMapping("/handle-login")
    public String handleLogin(
            @ModelAttribute(name = "dataLogin") Account account,
            Model model
    ){
        // xu li logic dang nhap
        Account dataLogin = accounts.stream().
                filter(p -> p.getUsername().equals(account.getUsername()) && p.getPassword().equals(account.getPassword()))
                .findFirst().orElse(null);
        if (dataLogin == null){
            model.addAttribute("error" , "TK or MK sai");
            return "login-form";
        }else{
            System.out.println("Dang nhap thanh cong" + account.getFullname());

            return "home";
        }
    }

    // dang xuat
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "home";
    }
}
