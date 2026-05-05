package com.example.artwork_management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ArtworkDTO {
    @NotBlank(message = "khon duoc de trong")
    @Length(min = 5 , max = 150 , message = "Do dai phai lon hon 5 ki tu va it hon 150 ki tu")
    private String title;

    @NotBlank(message = "khong duoc de trong")
    private String artist;

    @NotNull(message = "khong duoc de trong")
    @Min(value = 1,message = "Gia tien phai la so duong")
    private Double price;

    @Past(message = "Thoi gian chhi co trong qua khu")
    private LocalDateTime releaseDate;

    @NotNull(message = "khong duoc de trong")
    private MultipartFile image;

    private Boolean status;
}
