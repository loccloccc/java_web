package com.example.session04.dao;

import com.example.session04.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDAO {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Nguyễn Thị Kim Lệ",20,true),
                    new Student(2, "Nguyễn Tiến Minh",20,false),
                    new Student(3, "Đinh Quốc Khánh",20,false)
            )
    );

    // Phương thức lấy về danh sách
    public List<Student> findAll() {
        return this.students;
    }

    public List<Student> search( String keyword ) {
        return students.stream()
                .filter(s -> s.getFullName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
