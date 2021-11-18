package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.repository.PlanetRepository;
import com.example.Springbootrestapi.service.PlanetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;

    public Planet addNewPlanet(Planet planet) {
        log.info("Adding new Planet {}", planet);
        return planetRepository.save(planet);
    }

    public void destroyPlanet(Long id) {
        log.info("Destroying Planet by id {}", id);
        planetRepository.deleteById(id);
    }

}
