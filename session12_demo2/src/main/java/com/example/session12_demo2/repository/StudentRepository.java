package com.example.session12_demo2.repository;


import com.example.session12_demo2.dto.StudentDTO;
import com.example.session12_demo2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1L,"Tien Minh",19,false,"Thanh Hoa"),
                    new Student(2L,"Thi Phuong",19,true,"Thai Binh")
            )
    );

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
