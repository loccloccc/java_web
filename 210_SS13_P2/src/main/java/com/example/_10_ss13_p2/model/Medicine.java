package com.example._10_ss13_p2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private String unit;
}
