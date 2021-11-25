package com.example.Springbootrestapi.rest.v2;

import com.example.Springbootrestapi.model.Planet;
import com.example.Springbootrestapi.service.impl.PlanetServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v2/planets/")
public class PlanetRestControllerV2 {

    private static final String redirect = "redirect:/api/v2/planets/";
    private final PlanetServiceImpl planetService;

    @GetMapping("/")
    public String planets(Model model) {
        List<Planet> planetList = planetService.getAll();
        model.addAttribute("planetList", planetList);

        return "planets";
    }

    @PostMapping("create")
    public String addNewPlanet(Planet planet) {
        planetService.addNewPlanet(planet);

        return redirect;
    }

    @PostMapping("delete/{id}")
    public String destroyPlanet(@PathVariable Long id) {
        planetService.destroyPlanet(id);

        return redirect;
    }

    @GetMapping("overlords")
    public String goToOverlords() {
        return "redirect:/api/v2/overlords/";
    }
}
