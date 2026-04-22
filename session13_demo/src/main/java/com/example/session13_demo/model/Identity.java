package com.example.session13_demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "identitys")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cccd;

    // quan he has-a (qh 1-1)
    @OneToOne
    @JoinColumn(name = "person_id")

    private Person person;
}
