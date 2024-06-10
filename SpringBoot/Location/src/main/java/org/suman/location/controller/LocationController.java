package org.suman.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String displayLocations(@ModelAttribute("msg") String msg, Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, Model model) {
        Location location = locationService.getLocationById(id);
        String msg = "Location Deleted with Id: " + location.getId();
        locationService.deleteLocation(location);
        model.addAttribute("msg", msg);
        return "redirect:/displayLocations?msg=" + msg;
    }

    @RequestMapping("/editLocation")
    public String editLocation(@RequestParam("id") int id, Model model) {
        Location location = locationService.getLocationById(id);
        model.addAttribute("location", location);
        return "editLocation";
    }

    @RequestMapping("/")
    public String greet() {
        return "greet";
    }
}
