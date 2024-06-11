package org.suman.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.suman.location.entities.Location;
import org.suman.location.repos.LocationRepository;
import org.suman.location.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class RestLocationController {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {
        return locationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
