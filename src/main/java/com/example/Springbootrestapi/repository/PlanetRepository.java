package com.example.Springbootrestapi.repository;

import com.example.Springbootrestapi.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository <Planet, Long> {
}
