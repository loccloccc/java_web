package com.example.demo4.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Player {
    private Long id;
    private String name;
    private String position;
    private Integer jerseyNumber;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    // Constructor rỗng
    public Player() {
    }

    // Constructor đầy đủ tham số

    public Player(Long id, String name, String position, Integer jerseyNumber, String avatar, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.avatar = avatar;
        this.birthDay = birthDay;
    }

    // Getter & Setter
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
