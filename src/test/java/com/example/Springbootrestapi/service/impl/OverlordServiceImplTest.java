package com.example.Springbootrestapi.service.impl;

import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.repository.OverlordRepository;
import com.example.Springbootrestapi.service.OverlordService;
import com.example.Springbootrestapi.service.impl.OverlordServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OverlordServiceImplTest {

    private Overlord overlordTest;
    private final List<Overlord> overlordListTest = new ArrayList<>();

    @Mock
    private OverlordRepository overlordRepository;

    @Mock
    private OverlordService overlordUnderTest = new OverlordServiceImpl(overlordRepository);


    @Test
    public void addNewOverlord() {
        Overlord overlord = overlordUnderTest.addNewOverlord(overlordTest);
        assertEquals(overlordTest, overlord);
    }

    @Test
    public void appointmentOfAnOverlordForThePlanet() {
        Overlord overlord = overlordUnderTest.appointmentOfAnOverlordForThePlanet(overlordTest);
        assertEquals(overlordTest, overlord);
    }

    @Test
    public void idlersOverlords() {
        List<Overlord> overlordList = overlordUnderTest.idlersOverlords();
        assertEquals(overlordListTest, overlordList);
    }

    @Test
    public void youngestOverlords() {
        List<Overlord> overlordList = overlordUnderTest.youngestOverlords();
        assertEquals(overlordListTest, overlordList);
    }
}
