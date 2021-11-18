package com.example.Springbootrestapi.service;

import com.example.Springbootrestapi.model.Overlord;

import java.util.List;

public interface OverlordService {

    Overlord addNewOverlord(Overlord overlord);

    Overlord appointmentOfAnOverlordForThePlanet(Overlord overlord);

    List<Overlord> idlersOverlords();

    List<Overlord> youngestOverlords();
}
