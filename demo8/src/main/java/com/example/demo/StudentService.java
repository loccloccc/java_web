package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Page<Student> findByName(String name, Pageable pageable) {
        return studentRepository.findByName(name,pageable);
    }
}
