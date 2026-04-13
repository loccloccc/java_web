package com.example.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UplaodController {


    @GetMapping
    public String formUpload() {
        return "form-upload";
    }

    @PostMapping
    public String handleUpload(
            @RequestParam(name = "file") MultipartFile file,
            Model model
    ) {

        String path = "C:\\Users\\loc\\OneDrive\\Máy tính\\Java Web\\session07\\src\\main\\webapp\\images\\";
        if (file.isEmpty()) {
            model.addAttribute("error", "Đang không có file gửi lên");
            return "result";
        }
        // B1: lấy được tên file upload lên
        String fileName = file.getOriginalFilename();
        // B2: Khởi tạo đối tượng file với đường dẫn mong muốn
        File convertFile = new File(path + fileName);
        // B3: ghi vào ổ cứng (dự án)
        try {
            file.transferTo(convertFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("img", fileName);

        return "result";
    }

}