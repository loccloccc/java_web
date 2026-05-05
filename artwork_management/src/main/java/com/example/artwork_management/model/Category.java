package com.example.artwork_management.model;

import com.example.artwork_management.service.IArtwork;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categorys")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description; // mo ta

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artwork_id")
    private List<Artwork> artworks;

}
