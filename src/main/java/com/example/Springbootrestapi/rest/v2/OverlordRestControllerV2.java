package com.example.Springbootrestapi.rest.v2;

import com.example.Springbootrestapi.model.Overlord;
import com.example.Springbootrestapi.service.impl.OverlordServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v2/overlords/")
public class OverlordRestControllerV2 {

    private final String redirect = "redirect:/api/v2/overlords/";
    private final OverlordServiceImpl overlordServiceImpl;

    @GetMapping("/")
    public String overlords(Model model) {
        List<Overlord> overlordList = overlordServiceImpl.getAll();
        model.addAttribute("overlordList",overlordList);

        return "overlords";
    }

    @PostMapping("create")
    public String addNewOverlord(Overlord overlord) {
        overlordServiceImpl.addNewOverlord(overlord);

        return redirect;
    }

    @PostMapping("update/{overlord_id}")
    public String appointmentOfAnOverlordForThePlanet(@PathVariable Long overlord_id, Long planet_id) {
        overlordServiceImpl.appointmentOfAnOverlordForThePlanet(overlord_id, planet_id);

        return redirect;
    }

    @GetMapping("idlers")
    public String idlersOverlords(Model model) {
        List<Overlord> overlordList = overlordServiceImpl.idlersOverlords();
        model.addAttribute("idlersOverlordList", overlordList);

        return "overlord-idlers";
    }

    @PostMapping("update-idlers/{overlord_id}")
    public String appointmentOfAnIdlerOverlordForThePlanet(@PathVariable Long overlord_id, Long planet_id) {
        overlordServiceImpl.appointmentOfAnOverlordForThePlanet(overlord_id, planet_id);

        return "redirect:/api/v2/overlords/idlers";
    }

    @GetMapping("youngest")
    public String youngestOverlords(Model model) {
        List<Overlord> overlordList = overlordServiceImpl.youngestOverlords();
        model.addAttribute("youngestOverlordList",overlordList);

        return "overlord-youngest";
    }

    @GetMapping("back")
    public String back() {
        return redirect;
    }

    @GetMapping("planets")
    public String goToPlanets() {
        return "redirect:/api/v2/planets/";
    }
}
