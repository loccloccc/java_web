package com.example.session04.controller;

import com.example.session04.dao.StudentDAO;
import com.example.session04.model.Student;
import com.example.session04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


// đánh dấu bean là 1 controller
@Controller
// đây là 1 đường dẫn đến controller
@RequestMapping // mặc định dấu /

/**
 * các annotation phổ biến :
 * @Component : đánh dấu là bean khởi tạo và không có ngữ nghĩa,
 * @Controller : đánh dấu là bean và mục đích là điều hướng (lễ tân ),
 * @Service : đánh dấu là bean , mục đích là nghiệp vụ,
 * @Repository : đánh dấu là bean , mục đích là xử lí tương tác database (package DAO),
 * @Autowired : dùng đểt tiêm sự phụ thuộc (DI - Dependency Ịnection) (package Service)
 */


public class HomeController {

    // DI
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDAO studentDAO;

    // Chức năng 1 có đường dẫn gì
    // Đại diện cho 1 tính năng của người giúp việc (rửa bát)

    /**
     * biến của @RequestMapping
     * - @GetMapping: đại diện cho phương thức GET - cần tập trung
     * - @PostMapping: đại diện cho phương thức POST - cần tập trung
     * - @PutMapping: đại diện cho phương thức PUT
     * - @PatchMapping: đại diện cho phương thức PATCH
     * - @DeleteMapping: đại diện cho phương thức DELETE
     */

//    @RequestMapping(method = RequestMethod.GET) - cách cũ
    @GetMapping // - cách mới
    public String home(Model model) {
        List<Student> students = studentService.getAllStudent();
        System.out.println(students);

        model.addAttribute("listStudent", students);

        return "home";
    }

    @GetMapping("/search")
    public String search(
            // name đại diện cho key của tham số (có thể tự đặt)
            // defaultValue đại diện cho giá trị mặc định khi nó không gửi giá trị
            @RequestParam(name = "full_name", defaultValue = "") String keyword,
            Model model) {
        System.out.println("nội dung: " + keyword);
        // Bây giờ làm sao để tìm kiếm
        List<Student> students = studentDAO.search(keyword);
        model.addAttribute("listStudent", students);
        return "home";
    }
}
