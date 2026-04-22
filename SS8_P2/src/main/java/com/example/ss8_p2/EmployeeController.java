package com.example.ss8_p2;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @PostMapping("/hr/add-employee")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeDto employee,   // @ModelAttribute nên để rõ ràng
            BindingResult bindingResult,                               // ← PHẢI nằm NGAY SAU employee
            Model model) {                                             // Model để sau cùng

        if (bindingResult.hasErrors()) {
            // Giữ lại dữ liệu người dùng đã nhập (không bị mất)
            return "employee-form";   // Trả về đúng tên template Thymeleaf
        }

        // Gọi Service để lưu vào DB...
        // employeeService.save(employee);

        return "redirect:/hr/success";
    }
}
//Phần 1 – Phân tích lỗi
//Mặc dù code controller đã có kiểm tra if (bindingResult.hasErrors()) và return về "employee-form", nhưng hệ thống vẫn quăng 400 Bad Request - MethodArgumentNotValidException và hiển thị trang trắng là vì thứ tự tham số (parameter order) trong phương thức không đúng.
//Nguyên nhân chính:
//
//Trong Spring MVC, khi dùng @Valid với @ModelAttribute, BindingResult phải nằm ngay lập tức sau tham số được validate.
//Trong code hiện tại, thứ tự là:
//@Valid @ModelAttribute("employee") EmployeeDto employee
//Model model
//BindingResult bindingResult
//
//
//→ BindingResult không nằm ngay sau employee nên Spring không liên kết được hai đối tượng này.
//→ Khi validation thất bại (ví dụ: tuổi = 16), Spring không gọi vào method mà trực tiếp ném ra MethodArgumentNotValidException → dẫn đến lỗi 400 Bad Request và trang trắng (error page mặc định của Spring).
//Đây là một lỗi rất phổ biến khi làm form với Thymeleaf/Spring MVC.
