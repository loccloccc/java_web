package com.example.session12_demo2.service;

import com.example.session12_demo2.dto.StudentDTO;
import com.example.session12_demo2.model.Student;
import com.example.session12_demo2.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public List<Student> findAll(){
        return studentRepository.getStudents();
    }

    public void addStudent(StudentDTO studentDTO){
        Student optionalStudent = studentRepository.getStudents()
                .stream().max(Comparator.comparingLong(Student::getId)).orElse(null);

        Student newStudent = Student.builder()
                .name(studentDTO.getFullname())
                .age(studentDTO.getAge())
                .gender(studentDTO.getGender())
                .address(studentDTO.getAddress())
                .id(optionalStudent == null ? 1 : optionalStudent.getId() + 1).build();

        studentRepository.addStudent(newStudent);
    }
}
