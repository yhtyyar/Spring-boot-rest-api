package com.example.Springbootrestapi.dto;

import com.example.Springbootrestapi.model.Overlord;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
public class OverlordDto {

    private Long id;
    private String name;
    private int age;
    private List<PlanetDto> planets;

    //TODO: finish toEntity method
    public Overlord toEntity() {
        return Overlord.builder()
                .id(this.id)
                .build();
    }

    public static OverlordDto fromEntity(Overlord overlord) {
        if (Objects.isNull(overlord)) {
            return null;
        }

        List<PlanetDto> planetDtos = CollectionUtils.isEmpty(overlord.getPlanetList()) ?
                Collections.emptyList() :
                overlord.getPlanetList().stream().map(PlanetDto::fromEntity).collect(Collectors.toList());
        return OverlordDto.builder()
                .id(overlord.getId())
                .name(overlord.getName())
                .age(overlord.getAge())
                .planets(planetDtos)
                .build();
    }
}

