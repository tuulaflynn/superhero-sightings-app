package com.superherosightings.controller;

import com.superherosightings.dao.SightingDao;
import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SightingDto;
import com.superherosightings.model.SuperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// @CrossOrigin             add this later once we make it fullstack as it will not be the tomcat server calling.

@RestController
@RequestMapping("api")      // for future version it means all that needs to be changed is this mapping rather than all the endpoints individually.
public class SightingController {

    private SightingDao sightingDao;

    @Autowired
    public SightingController(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }

    // http://localhost:8081/api/sightings
    @PostMapping("sightings")
    public ResponseEntity<SightingDto> addSighting(@RequestBody SightingDto sightingDto) {
        return null;
    }

    // http://localhost:8081/api/sightings/supers/2
    @GetMapping("sighting/supers/{locationId}")
    public ResponseEntity<List<SuperDto>> fetchSupersByLocation(@PathVariable("locationId") int locationId) {
        return null;
    }

    // http://localhost/8081/api/sightings/locations/3
    @GetMapping("sightings/locations/{superId}")
    public ResponseEntity<List<LocationDto>> fetchLocationsBySuper(@PathVariable("superId") SuperDto super_id) {
        return null;
    }

    // http://localhost/8081/api/sightings/2023-05-27       CHECK THE PATH VARIABLE FOR A DATE CAN BE WRITTEN LIKE THIS
    @GetMapping("sightings/{sightingDate}")
    public List<SightingDto> fetchSightingByDate(@PathVariable("sightingDate") LocalDate sighting_date) {
        return null;
    }
}
