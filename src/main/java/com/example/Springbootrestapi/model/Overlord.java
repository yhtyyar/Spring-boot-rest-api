package com.example.Springbootrestapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "overlords")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Overlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "overlord", cascade = CascadeType.ALL)
    private List<Planet> planetList;
}
