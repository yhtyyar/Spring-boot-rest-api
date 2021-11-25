package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.repository.PlanetRepository;
import com.example.Springbootrestapi.service.PlanetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;


    @Override
    public Planet addNewPlanet(Planet planet) {
        log.info("Adding new Planet {}", planet.toString());
        return planetRepository.save(planet);
    }


    @Override
    public void destroyPlanet(Long id) {
        log.info("Destroying Planet by id {}", id);
        planetRepository.deleteById(id);
    }


    @Override
    public List<Planet> getAll() {
        log.info("Get all Planets");
        List<Planet> planetList = planetRepository.findAll();
        if(CollectionUtils.isEmpty(planetList)) {
            return Collections.emptyList();
        }
        return planetList;
    }

}
