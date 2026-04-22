package com.example.ss8_p1.controller;

import com.example.ss8_p1.dto.AddressDto;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class UserController {

    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(
            @Valid @RequestBody AddressDto addressDto) {   // ← Thêm @Valid ở đây

        // Logic lưu database (bạn có thể thêm service sau)
        // addressService.updateAddress(addressDto);

        return ResponseEntity.ok("Cập nhật địa chỉ thành công!");
    }
}

//Phần 1 – Phân tích logic (ngắn gọn)
//
//Lỗi (1): Lọt khoảng trắng vào Database
//@NotNull chỉ kiểm tra không được null, chứ không kiểm tra nội dung chuỗi.
//Khi người dùng nhập "   " (nhiều dấu space), chuỗi vẫn khác null → validation pass → hệ thống lưu "   " vào DB → bưu tá nhận địa chỉ trắng tinh.
//Lỗi (2): Không chặn được request từ Postman → lỗi 500
//Trong Controller không có @Valid trước AddressDto.
//→ Bean Validation (JSR 380) không được kích hoạt.
//Khi hacker gửi JSON thiếu receiverName hoặc detailedAddress (hoặc để null), Spring bỏ qua validation, request đi thẳng vào logic lưu DB → gây NullPointerException hoặc lỗi DB → server trả về 500 Internal Server Error thay vì chặn lại bằng lỗi 400 Bad Request.
