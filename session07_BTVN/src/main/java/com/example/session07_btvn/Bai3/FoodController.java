package com.example.session07_btvn.Bai3;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    @PostMapping("/food/add")
    public String addFood(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file
    ) throws IOException {


        if (file.isEmpty()) {
            throw new RuntimeException("Phải đính kèm ảnh!");
        }


        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new RuntimeException("Sai định dạng file, chỉ chấp nhận image/*");
        }


        if (price < 0) {
            throw new RuntimeException("Giá tiền phải >= 0");
        }


        String filePath = "C:\\Users\\loc\\OneDrive\\Máy tính\\Java Web\\session07_BTVN\\src\\main\\webapp\\images\\" + file.getOriginalFilename();
        file.transferTo(new File(filePath));


        Food food = new Food(name, category, price, filePath);
        foodList.add(food);


        System.out.println("Đã thêm món: " + food.getName() + " - " + food.getCategory() + " - " + food.getPrice());
        System.out.println("Tổng số món hiện tại: " + foodList.size());

        return "success";
    }
}