package com.example.Springbootrestapi.service;

import com.example.Springbootrestapi.model.Planet;

public interface PlanetService {

    Planet addNewPlanet(Planet planet);

    void destroyPlanet(Long id);
}
