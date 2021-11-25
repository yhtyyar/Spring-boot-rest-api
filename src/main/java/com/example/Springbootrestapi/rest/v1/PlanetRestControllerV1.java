package com.example.Springbootrestapi.rest.v1;

import com.example.Springbootrestapi.dto.PlanetDto;
import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.service.impl.PlanetServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/planets")
public class PlanetRestControllerV1 {

    private final PlanetServiceImpl planetService;


    @PostMapping
    public ResponseEntity<?> addNewPlanet(@RequestBody @NonNull PlanetDto planetDto) {
        Planet createdPlanet = planetService.addNewPlanet(planetDto.toEntity());
        return  new ResponseEntity<>(PlanetDto.fromEntity(createdPlanet), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroyPlanet(@PathVariable ("id") Long id) {
        planetService.destroyPlanet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
