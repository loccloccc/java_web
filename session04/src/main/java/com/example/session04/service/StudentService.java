package com.example.session04.service;

import com.example.session04.dao.StudentDAO;
import com.example.session04.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // Tiêm sự phụ thuộc (DI - Dependency Injection)
    @Autowired
    private StudentDAO studentDAO;

    public List<Student> getAllStudent() {
        List<Student> students = studentDAO.findAll();
        return students;
    }

}
