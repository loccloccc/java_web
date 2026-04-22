package com.example.hnk24cntt4_duongducloc_001.controller;

import com.example.hnk24cntt4_duongducloc_001.dto.BookDTO;
import com.example.hnk24cntt4_duongducloc_001.model.Book;
import com.example.hnk24cntt4_duongducloc_001.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String home(Model model){
        model.addAttribute("listBook",bookRepository.getList());
        return "book-home";
    }

    @GetMapping("/handle-view-add")
    public String AddBook(
            Model model
            ){
        model.addAttribute("bookDTO",new BookDTO());
        return "form-add";
    }

    @PostMapping("/handle-add")
    public String submitAdd(
            @Valid @ModelAttribute(name = "bookDTO") BookDTO bookDTO,
            BindingResult br,
            Model model
    ){
        if (br.hasErrors()){
            model.addAttribute("bookDTO",bookDTO);
            return "form-add";
        }
        Long newID  = (long) bookRepository.getList().size() + 1;
        Book newBook = new Book(
                newID,
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getQuantity(),
                uploadFile(bookDTO.getCoverImage())
        );
        bookRepository.getList().add(newBook);
        return "redirect:/";
    }

    public String uploadFile(MultipartFile file) {
            String path = "C:\\Users\\loc\\OneDrive\\Máy tính\\Java Web\\HN-K24-CNTT4_DuongDucLoc_001\\src\\main\\webapp\\images\\";
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
    @GetMapping("/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id,
            Model model
    ){
        Book book = bookRepository.getList().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("bookDTO",book);
        return "view-update";
    }




    @PostMapping("/handle-update")
    public String submitUpdate(
            @ModelAttribute(name = "bookDTO") BookDTO bookDTO
    ){
        for (Book b : bookRepository.getList()){
            if (b.getId().equals(bookDTO.getId())){
                b.setTitle(bookDTO.getTitle());
                b.setAuthor(bookDTO.getAuthor());
                b.setQuantity(bookDTO.getQuantity());
                b.setCoverImage(bookDTO.getCoverImage().isEmpty() ? b.getCoverImage() : uploadFile(bookDTO.getCoverImage()));
            }
        }
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(
            @PathVariable(name = "id") Long idDelete
            ){
        bookRepository.getList().removeIf(b -> b.getId().equals(idDelete));
        return "redirect:/";
    }

}
