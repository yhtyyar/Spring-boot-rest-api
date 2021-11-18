package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.repository.OverlordRepository;
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

    public Overlord addNewOverlord(Overlord overlord) {
        log.info("Adding new Overlord {} ", overlord);
        return overlordRepository.save(overlord);
    }

    public Overlord appointmentOfAnOverlordForThePlanet(Overlord overlord) {
        log.info("Appointment of an Overlord for the Planet {} ", overlord);
        return overlordRepository.save(overlord);
    }

    public List<Overlord> idlersOverlords() {
        log.info("All idlers Overlords");
        List<Overlord> overlordList = overlordRepository.findAll();
        if(CollectionUtils.isEmpty(overlordList)) {
            return Collections.emptyList();
        }

        return overlordList.stream().filter(o -> !CollectionUtils.isEmpty(o.getPlanetList()))
                .collect(Collectors.toList());
    }

    // Отображение ТОП 10 самых молодых Повелителей
    public List<Overlord> youngestOverlords() {
        log.info("Top 10 youngest Overlords");
        List<Overlord> overlordList = overlordRepository.findAll();
        if(CollectionUtils.isEmpty(overlordList)) {
            return Collections.emptyList();
        }
        //TODO: check this method
        return overlordList.stream().sorted(Comparator.comparing(Overlord::getAge)).limit(10)
                .collect(Collectors.toList());

    }

}

