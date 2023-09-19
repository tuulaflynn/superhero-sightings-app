package com.superherosightings.controller;

import com.superherosightings.model.SightingDto;
import com.superherosightings.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("api")      // for future version it means all that needs to be changed is this mapping rather than all the endpoints individually.
public class SightingController {

    private SightingService sightingService;

    @Autowired
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping("sightings")
    public ResponseEntity<List<SightingDto>> fetchAllSightings() {
        return new ResponseEntity<List<SightingDto>>(sightingService.fetchAllSightings(), HttpStatus.OK);
    }

    // http://localhost:8081/api/sightings
    @PostMapping("sightings")
    public ResponseEntity<SightingDto> addSighting(@RequestBody SightingDto newSightingDto) {
        System.out.println("controller");
        return new ResponseEntity<>(sightingService.addSighting(newSightingDto), HttpStatus.OK);
    }


    // http://localhost:8081/api/sightings/2023-05-27       // the path variable can be written like this for a date
    @GetMapping("sightings/{sightingDate}")
    public List<SightingDto> fetchSightingByDate(@PathVariable("sightingDate") LocalDate sightingDate) {
        return sightingService.fetchSightingByDate(sightingDate);
    }
}
