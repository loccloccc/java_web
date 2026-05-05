package com.example._10_ss13_p4.repository;




import com.example._10_ss13_p4.model.Medicine;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MedicineRepository {

    private final SessionFactory sessionFactory;

    /**
     * Tìm các loại thuốc đã hết hạn sử dụng.
     */
    public List<Medicine> findExpiredMedicines() {
        Session session = sessionFactory.openSession();
        List<Medicine> expiredMedicines = null;

        try {
            // HQL: Truy vấn trên Class Medicine (m) và thuộc tính expiryDate
            // Dùng tham số :today để chống SQL Injection
            String hql = "SELECT m FROM Medicine m WHERE m.expiryDate < :today";

            expiredMedicines = session.createQuery(hql, Medicine.class)
                    .setParameter("today", LocalDate.now()) // Gán giá trị an toàn vào tham số
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return expiredMedicines;
    }
}