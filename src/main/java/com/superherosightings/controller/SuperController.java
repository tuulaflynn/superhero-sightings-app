package com.superherosightings.controller;

import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SuperDto;
import com.superherosightings.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class SuperController {

    SuperService superService;

    @Autowired
    public SuperController(SuperService superService) {
        this.superService = superService;
    }

    // http://localhost:8081/api/sightings/locations/3
    @GetMapping("sightings/locations/{superId}")
    public ResponseEntity<List<LocationDto>> fetchLocationsBySuper(@PathVariable("superId") int superId) {
        return new ResponseEntity<List<LocationDto>>(superService.fetchLocationsBySuper(superId), HttpStatus.OK);
    }
}
