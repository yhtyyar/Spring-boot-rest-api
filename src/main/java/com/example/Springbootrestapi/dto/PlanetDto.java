package com.example.Springbootrestapi.dto;

import com.example.Springbootrestapi.model.Planet;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class PlanetDto {

    private Long id;
    private String name;
    private OverlordDto overlord;

    //TODO: finish toEntity method
    public Planet toEntity() {
        return Planet.builder()
                .id(this.id)
                .build();
    }

    public static PlanetDto fromEntity(Planet planet) {
        if(Objects.isNull(planet)) {
            return null;
        }
        return PlanetDto.builder()
                .id(planet.getId())
                .name(planet.getName())
                .overlord(OverlordDto.fromEntity(planet.getOverlord()))
                .build();
    }
}
