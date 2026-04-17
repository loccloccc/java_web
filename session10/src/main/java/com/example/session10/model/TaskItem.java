package com.example.session10.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItem {
    private String id;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadline;
    private Priority priority;

    public TaskItem() {
    }

    public TaskItem(String id, String name, LocalDate deadline, Priority priority) {
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
