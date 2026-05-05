package com.example.artwork_management.model;


import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "artworks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private Double price;

    private LocalDateTime releaseDate;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "category_id")
    private Category categories;
    private Boolean status;

}
