package com.example.session08_demo.dto;

import com.example.session08_demo.model.Gender;
import com.example.session08_demo.validator.EmailExist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// khi làm việc với DB thì khôngn cần nhập id
public class PersonDTO {
    @Min(1)
    private Long id;
    @NotBlank(message = "Ten khong duoc bo trong")
    private String name;
    private Gender gender;
    @Past(message = "Khong duoc lon hon ngay hien tai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Min(value = 18 , message = "Phai nhap tren 18 tuoi")
    private Integer age;
    @NotBlank(message = "Email khong duoc de trong")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Email khong dung dinh dang"
    )
    @EmailExist
    private String email;

    public PersonDTO() {}

    public PersonDTO(Long id, String name, Gender gender, LocalDate dateOfBirth, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
