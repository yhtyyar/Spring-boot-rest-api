package com.example.Springbootrestapi.rest;

import com.example.Springbootrestapi.dto.OverlordDto;
import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.service.impl.OverlordServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/overlords")
public class OverlordRestControllerV1 {

    private final OverlordServiceImpl overlordServiceImpl;

    @GetMapping("/")
    public String overlords() {
        return "overlords" ;
    }

    @PostMapping
    public ResponseEntity<?> addNewOverlord(@RequestBody @NonNull OverlordDto overlordDto) {

        Overlord overlord = overlordServiceImpl.addNewOverlord(overlordDto.toEntity());
        return new ResponseEntity<>(OverlordDto.fromEntity(overlord), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> appointmentOfAnOverlordForThePlanet(@RequestBody @NonNull OverlordDto overlordDto) {
        Overlord updatedOverlord = overlordServiceImpl.appointmentOfAnOverlordForThePlanet(overlordDto.toEntity());
        return new ResponseEntity<>(OverlordDto.fromEntity(updatedOverlord),HttpStatus.OK);
    }

    @GetMapping(value = "/idlers")
    public ResponseEntity<?> idlersOverlords() {
        List<Overlord> overlordList = overlordServiceImpl.idlersOverlords();
        if (CollectionUtils.isEmpty(overlordList)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<OverlordDto> dtos = overlordList.stream().map(OverlordDto::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/youngest")
    public ResponseEntity<?> youngestOverlords() {
        List<Overlord> overlordList = overlordServiceImpl.youngestOverlords();
        if (CollectionUtils.isEmpty(overlordList)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<OverlordDto> dtos = overlordList.stream().map(OverlordDto::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}

