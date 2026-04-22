package com.example.demo5.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class PlayerDTO {
    private Long id;
    @NotBlank(message = "Khong duoc de trong")
    private String name;
    @NotBlank(message = "Khong duoc de trong")
    private String positio;
    private Integer jerseyNumber;
    private MultipartFile avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    public PlayerDTO() {}

    public PlayerDTO(Long id, String name, String positio, Integer jerseyNumber, MultipartFile avatar, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.positio = positio;
        this.jerseyNumber = jerseyNumber;
        this.avatar = avatar;
        this.birthDay = birthDay;
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

    public String getPositio() {
        return positio;
    }

    public void setPositio(String positio) {
        this.positio = positio;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
