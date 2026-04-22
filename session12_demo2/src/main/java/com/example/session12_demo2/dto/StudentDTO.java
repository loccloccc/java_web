package com.example.session12_demo2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    @NotBlank(message = "khong duoc de trong")
    private String fullname;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 18 , message = "Khong duoc duoi 18")
    private Integer age;
    @NotNull(message = "Khong duoc de trong")
    private Boolean gender;
    @NotBlank(message = "Khong duoc de trong")
    private String address;
}