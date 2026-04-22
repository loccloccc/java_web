package com.example.hnk24cntt4_duongducloc_001.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class BookDTO {
    private Long id;
    @NotBlank(message = "Không đươc để trống tên sách")
    private String title;
    @NotBlank(message = "Không đươc để trống tên tác giả")
    private String author;
    @Min(value = 1 , message = "Số lượng phải lớn hơn 1")
    @NotNull(message = "Không được để trống số lượng")
    private Integer quantity;
    private MultipartFile coverImage;

    public BookDTO() {}

    public BookDTO(Long id, String title, String author, Integer quantity, MultipartFile coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }
}
