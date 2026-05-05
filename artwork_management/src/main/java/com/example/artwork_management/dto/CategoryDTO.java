package com.example.artwork_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
@Setter
public class CategoryDTO {
    @Length(min=5, max=150 , message = "Do dai phai lon hon 5 ki tu va it hon 150 ki tu")
    @NotBlank(message = "khong duoc de trong")
    private String name;
}
