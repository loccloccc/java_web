package com.example.btvn.bai2;

public class bai2 {
    public static void main(String[] args) {
//        | # | Vị trí                                                                 | Loại vấn đề                          | Mô tả hậu quả                                                                                                                                                                       |
//        | - | ---------------------------------------------------------------------- | ------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
//        | 1 | `<%! private int requestCounter = 0; %>`                               | **Race Condition / Shared State**    | Đây là **biến instance của JSP Servlet**, được dùng chung cho tất cả request. Khi nhiều user truy cập cùng lúc có thể gây **race condition**, giá trị đếm sai và không thread-safe. |
//        | 2 | `<% requestCounter++; %>`                                              | **Logic trong View**                 | JSP chỉ nên dùng để **hiển thị dữ liệu**, không nên chứa logic xử lý. Việc đếm request phải nằm trong **Controller hoặc Service**, không phải View.                                 |
//        | 3 | `<% List<Student> list = (List<Student>) request.getAttribute(...) %>` | **Scriptlet / MVC Violation**        | JSP đang trực tiếp truy cập `request` và ép kiểu dữ liệu. Điều này phá vỡ **MVC separation**, làm View phụ thuộc vào Java code. Nên dùng **EL `${}`** thay thế.                     |
//        | 4 | `for (int i = 0; i < list.size(); i++)`                                | **Java Loop trong JSP**              | Dùng **Scriptlet loop** làm code khó đọc và khó bảo trì. Trong JSP chuẩn phải dùng **JSTL `<c:forEach>`**.                                                                          |
//        | 5 | Logic xếp loại trong JSP                                               | **Business Logic trong View**        | JSP đang chứa logic xếp loại điểm (`if-else`). Đây là **business logic**, nên đặt trong **Model hoặc Service**.                                                                     |

    }
}
