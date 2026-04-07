package com.example.btvn.bai3;

public class Bai3 {
//    Định nghĩa:
//    Input:
//    username: String   (tài khoản người chơi)
//    foodName: String   (tên món, ví dụ: "Mì xào bò")
//    quantity: int      (số lượng)
//    Output:
//    Thành công
//    "Đặt món thành công: Mì xào bò x2"
//
//    -Xử lý logic:
//    Nhận request từ user:
//    username
//            foodName
//    quantity
//    Kiểm tra tồn kho:
//    Nếu stock < quantity -> báo "Hết món"
//    Tính tiền:
//    price = đơn giá X số lượng
//    Kiểm tra số dư:
//    Nếu balance < price -> "Không đủ tiền"
//    Nếu hợp lệ:
//    Trừ kho
//    Trừ tiền
//    Trả kết quả thành công
//Tại sao thông báo lỗi đăng nhập phải lưu vào Request Scope mà không phải Session Scope? Điều gì sẽ xảy ra nếu lưu nhầm vào Session?
//    Lỗi sẽ không biến mất
//    Người dùng reload vẫn thấy lỗi
//    Sau khi login thành công vẫn còn lỗi -> UX rất tệ
//    Có thể lẫn trạng thái giữa các action
//
//
//    Tại sao totalViewCount phải lưu vào Application Scope? Nếu lưu vào Session Scope, mỗi nhân viên sẽ thấy con số khác nhau như thế nào?
//    Application	dùng chung toàn hệ thống
//    Session	riêng từng user
//    Mỗi người thấy số khác nhau
//    Không còn là “toàn hệ thống”
//
//
//    Race Condition là gì và tại sao đoạn code dưới đây có thể gây ra Race Condition trong môi trường nhiều người dùng đồng thời? Đề xuất cách phòng tránh:
//    // Đoạn code tiềm ẩn Race Condition — bạn phải giải thích và cải thiện
//    Integer count = (Integer) application.getAttribute("totalViewCount");
//if (count == null) count = 0;
//    count++;
//application.setAttribute("totalViewCount", count);
//    Race Condition xảy ra khi:
//    Nhiều thread cùng đọc/ghi cùng một dữ liệu → kết quả sai
//    Kết quả đúng phải là 7
//    nhưng thực tế là 6
//
//    AtomicInteger count = (AtomicInteger) application.getAttribute("totalViewCount");
//if (count == null) {
//        count = new AtomicInteger(0);
//        application.setAttribute("totalViewCount", count);
//    }
//count.incrementAndGet();
}
