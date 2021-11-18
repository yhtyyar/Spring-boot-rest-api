package com.example.Springbootrestapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "planets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "lord_id")
    private Overlord overlord;
}