package com.restaurant.Bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }
}
/*
GIẢI THÍCH:

- Cách A (/bai3/orders/5): số 5 nằm trong URI Path (đường dẫn).
- Cách B (/bai3/orders?id=5): số 5 nằm trong Query String (tham số).
- Khi lấy 1 đối tượng cụ thể theo ID thì nên dùng @PathVariable.
- Vì ID là định danh tài nguyên nên đặt trong URL sẽ đúng chuẩn REST hơn.
- => Chọn Cách A.
*/