package org.example.bai4;

public class bai4 {
//    1. Phân tích yêu cầu
//    Hệ thống Cyber Center cần gửi thông báo khi trừ tiền thành công cho khách hàng.
//    Thông báo có thể được gửi qua:
//    Email SMS
//    Vì vậy NotificationService cần sử dụng:
//    EmailSender SmsSender
//    Hai thành phần này sẽ được tiêm vào Service bằng Dependency Injection (DI) để đảm bảo hệ thống loose coupling và dễ mở rộng.
//    Ngoài ra có tình huống lỗi:
//    dịch vụ SMS có thể bị mất kết nối mạng, nên hệ thống cần dễ dàng xử lý lỗi hoặc thay thế dịch vụ.

//    Giải pháp 1: Constructor Injection
//    Đặc điểm
//    Dependency được tiêm qua constructor
//    Khi tạo object, Spring bắt buộc phải cung cấp dependency
//    Giải pháp 2: Field Injection
//    Đặc điểm
//    Dependency được tiêm trực tiếp vào field
//    Không cần constructor

//    4. Bảng so sánh hai giải pháp
//    Tiêu chí	                    Constructor Injection	            Field Injection
//    Cách tiêm	                    Qua constructor	                    Qua biến instance
//    Tính rõ ràng dependency	    Rất rõ ràng	                        Không rõ ràng
//    Khả năng test	                Dễ test bằng Mock	                Khó test
//    Khả năng phát hiện lỗi sớm	Có (lỗi khi khởi tạo bean)	        Thường phát hiện muộn
//    Khả năng bảo trì	            Tốt	                                Kém hơn
//    Khuyến nghị của Spring	    Khuyến nghị sử dụng	                Không khuyến khích

}
