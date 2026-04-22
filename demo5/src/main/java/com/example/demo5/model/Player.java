package com.example.demo5.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Player {
    private Long id;
    private String name;
    private String positio;
    private Integer jerseyNumber;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    public Player() {}

    public Player(Long id, String name, String positio, Integer jerseyNumber, String avatar, LocalDate birthDay) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
