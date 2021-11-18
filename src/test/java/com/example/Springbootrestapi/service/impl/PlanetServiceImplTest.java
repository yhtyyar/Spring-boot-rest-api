package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.repository.PlanetRepository;
import com.example.Springbootrestapi.service.PlanetService;
import com.example.Springbootrestapi.service.impl.PlanetServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlanetServiceImplTest {

    private Planet planetTest;

    @Mock
    private PlanetRepository planetRepository;

    @Mock
    private final PlanetService planetUnderTest = new PlanetServiceImpl(planetRepository);

    @Test
    public void addNewPlanetTest() {
        Planet planet = planetUnderTest.addNewPlanet(planetTest);
        assertEquals(planetTest,planet);
    }
}
