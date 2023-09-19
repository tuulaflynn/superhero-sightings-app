package com.superherosightings.controller;

import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;
import com.superherosightings.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin        // add this once we make it fullstack.
@RestController
@RequestMapping("api")
public class OrganisationController {

    private OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    // http://localhost:8081/api/supers/3
    @GetMapping("supers/{organisationId}")
    public ResponseEntity<List<SuperDto>> fetchSupersByOrganisation(@PathVariable("organisationId") int organisationId) {
        return new ResponseEntity<>(organisationService.fetchSupersByOrganisation(organisationId), HttpStatus.OK);
    }

}
