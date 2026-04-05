package org.example.bai2;

public class bai2 {
//    Trong mã nguồn, class `PlaySession` được đánh dấu bằng `@Component`, nên khi chạy trong **Spring**, class này sẽ được Spring Container quản lý như một **Bean**. Theo mặc định, các Bean trong Spring có **scope là Singleton**, nghĩa là trong toàn bộ ứng dụng **chỉ tồn tại một instance duy nhất của Bean đó**.
//
//    Do `PlaySession` là Singleton, tất cả các máy trạm trong hệ thống khi sử dụng `PlaySession` đều **dùng chung cùng một object**. Trong class này có biến `playTime`, biến này lưu thời gian chơi và có thể thay đổi thông qua phương thức `addTime()`. Vì chỉ có một instance duy nhất nên giá trị của `playTime` sẽ **bị chia sẻ giữa tất cả các máy**.
//
//    Khi máy số 01 nạp giờ và bắt đầu chơi, hệ thống sẽ tăng giá trị `playTime`. Tuy nhiên vì các máy khác cũng đang sử dụng **cùng một Bean `PlaySession`**, nên khi máy số 02 hoạt động hoặc hệ thống tiếp tục cập nhật thời gian, giá trị `playTime` đó vẫn được dùng chung. Điều này dẫn đến việc thời gian chơi của các máy bị cộng chung vào một biến, làm cho hệ thống hiểu sai rằng nhiều máy đang dùng chung một bộ đếm thời gian.
//
//    Chính vì vậy mới xảy ra hiện tượng **máy số 01 chơi nhưng máy số 02 cũng bị trừ tiền theo thời gian thực**. Nguyên nhân là do **Singleton Bean chứa trạng thái (state) dùng chung**, khiến dữ liệu giữa các máy trạm không được tách biệt, làm mất tính chính xác khi tính thời gian và tiền chơi.

}
