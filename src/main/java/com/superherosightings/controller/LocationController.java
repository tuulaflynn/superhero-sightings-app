package com.superherosightings.controller;

import com.superherosightings.model.SuperDto;
import com.superherosightings.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class LocationController {

    LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // http://localhost:8081/api/sightings/supers/2
    @GetMapping("sightings/supers/{locationId}")
    public ResponseEntity<List<SuperDto>> fetchSupersByLocation(@PathVariable("locationId") int locationId) {
        return new ResponseEntity<>(locationService.fetchSupersByLocation(locationId), HttpStatus.OK);
    }
}
