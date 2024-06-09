package org.suman.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suman.location.entities.Location;
import org.suman.location.service.LocationService;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "showCreate";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, Model model) {
        System.out.println("Reached this route");
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location Saved with Id: " + locationSaved.getId();
        model.addAttribute("msg", msg);

        return "showCreate";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/")
    public String greet() {
        return "greet";
    }
}
