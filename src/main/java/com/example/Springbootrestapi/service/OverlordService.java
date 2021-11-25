package com.example.Springbootrestapi.service;

import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.model.Planet;

import java.util.List;

public interface OverlordService {

    Overlord addNewOverlord(Overlord overlord);

    Overlord appointmentOfAnOverlordForThePlanet(Long overlord_id, Long planet_id);

    List<Overlord> idlersOverlords();

    List<Overlord> youngestOverlords();

    List<Overlord> getAll();
}
