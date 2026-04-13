package com.example.session07.repository;

import com.example.session07.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Nguyen Van A",true,21,"Ha Noi"),
                    new Student(2,"Nguyen Van B",false,21,"Phu Tho"),
                    new Student(3,"Nguyen Van C",true,21,"Ninh Binh"),
                    new Student(4,"Nguyen Van D",false,21,"Nam Dinh")
            )


    );
    // lay ve tat ca danh sach
    public List<Student> getAllStudent(){
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
