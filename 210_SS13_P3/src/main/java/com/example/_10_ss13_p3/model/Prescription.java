package com.example._10_ss13_p3.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ... các trường khác (bác sĩ, ngày tạo...)

    // Ánh xạ 1 Đơn thuốc -> Nhiều Chi tiết.
    // mappedBy: Trỏ tới tên biến 'prescription' nằm trong class PrescriptionDetail.
    // cascade: Tự động lưu/xóa các chi tiết khi Đơn thuốc bị lưu/xóa.
    // fetch = LAZY: Tối ưu hiệu năng, không tải chi tiết nếu không cần.
    // orphanRemoval = true: Tự động xóa dòng trong DB nếu ta remove chi tiết đó khỏi List.
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PrescriptionDetail> details = new ArrayList<>();

}
