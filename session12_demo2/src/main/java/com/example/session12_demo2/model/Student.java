package com.example.session12_demo2.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private boolean gender;
    private String address;


}
