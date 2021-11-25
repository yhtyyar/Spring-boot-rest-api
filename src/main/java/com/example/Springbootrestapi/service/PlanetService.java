package com.example.Springbootrestapi.service;

import com.example.Springbootrestapi.model.Planet;

import java.util.List;

public interface PlanetService {

    Planet addNewPlanet(Planet planet);

    void destroyPlanet(Long id);

    List<Planet> getAll();
}
