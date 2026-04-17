package com.example.session10.dto;

import com.example.session10.model.Priority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskDTO {
    @NotBlank(message = "Khong duoc de trong ten")
    private String id;
    @NotBlank(message = "Khong duoc de trong ten")
    @Length(min = 5 ,message = "Hay nhap chuoi lon hon 5 ki tu")
    private String name;
    @Future(message = "Thoi gian phai lon hon hien tai")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadline;
    private Priority priority;

    public TaskDTO() {}

    public TaskDTO(String id, String name, LocalDate deadline, Priority priority) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
