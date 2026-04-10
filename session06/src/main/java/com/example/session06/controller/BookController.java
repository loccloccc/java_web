package com.example.session06.controller;

import com.example.session06.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class BookController {
    List<Book> list = new ArrayList<>(
            Arrays.asList(
                    new Book(1,"Tao Thao","Duong Duc Loc",400000),
                    new Book(2,"Doan Ngoc Duy","Nguyen Van A",120000),
                    new Book(3,"Hoang Minh Chien","Nguyen Van B",110000),
                    new Book(4,"Han Tin","Nguyan Van C",150000)
            )
    );

    @GetMapping("/book")
    public String bookHome(Model model){
        model.addAttribute("bookList",list);
        return "bookRender";
    }

    @GetMapping("/detatils/{id}")
    public String detatil(
            @PathVariable(name = "id") int id,
            Model model
    ){
        Book books = list.stream().filter(b -> b.getId() == id).findAny().orElse(null);
        model.addAttribute("detail",books);
        return "details";
    }
}
