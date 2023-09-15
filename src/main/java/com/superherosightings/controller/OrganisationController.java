package com.superherosightings.controller;

import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;
import com.superherosightings.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller             // has @Component embedded in it
@RestController("api")
// @CrossOrigin        add this once we make it fullstack.
public class OrganisationController {

    private OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
    }

    // http://localhost:8081/api/supers/3
    @GetMapping("supers/{organisationId}")
    public ResponseEntity<List<SuperDto>> fetchSupersByOrganisation(@PathVariable("organisationId") int organisation_id) {
        return null;
    }

    // http://localhost:8081/api/organisations/2
    @GetMapping("organisations/{superId}")
    public List<OrganisationDto> fetchOrganisationsBySuper(@PathVariable("superId") int super_id) {
        return null;
    }
}
