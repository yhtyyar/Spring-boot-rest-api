package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.repository.OverlordRepository;
import com.example.Springbootrestapi.repository.PlanetRepository;
import com.example.Springbootrestapi.service.OverlordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OverlordServiceImpl implements OverlordService {

    private final OverlordRepository overlordRepository;
    private final PlanetRepository planetRepository;


    @Override
    public Overlord addNewOverlord(Overlord overlord) {
        log.info("Adding new Overlord {} ", overlord.toString());
        return overlordRepository.save(overlord);
    }


    @Override
    public Overlord appointmentOfAnOverlordForThePlanet(Long overlord_id, Long planet_id) {
        Overlord overlord = overlordRepository.getById(overlord_id);
        Planet planet = planetRepository.getById(planet_id);

        log.info("An attempt to appoint the Overlord of the Planet {} " + planet.getName(), overlord);

        if (planet.getOverlord() == null) {
            planet.setOverlord(overlord);
            planetRepository.save(planet);

            log.info("Successful change Planet {}", planet);
            return overlordRepository.getById(overlord_id);

        } else {
            log.info("The Planet already has a overlord {} ", planet);
            return overlordRepository.getById(overlord_id);
        }

    }


    @Override
    public List<Overlord> idlersOverlords() {
        log.info("All idlers Overlords");
        List<Overlord> overlordList = overlordRepository.findAll();
        if(CollectionUtils.isEmpty(overlordList)) {
            return Collections.emptyList();
        }

        return overlordList.stream().filter(o -> CollectionUtils.isEmpty(o.getPlanetList()))
                .collect(Collectors.toList());
    }


    // Отображение ТОП 10 самых молодых Повелителей
    @Override
    public List<Overlord> youngestOverlords() {
        log.info("Top 10 youngest Overlords");
        List<Overlord> overlordList = overlordRepository.findAll();
        if(CollectionUtils.isEmpty(overlordList)) {
            return Collections.emptyList();
        }

        return overlordList.stream().sorted(Comparator.comparing(Overlord::getAge)).limit(10)
                .collect(Collectors.toList());

    }


    @Override
    public List<Overlord> getAll() {
        log.info("Get all Overlords");

        return overlordRepository.findAll();
    }

}

