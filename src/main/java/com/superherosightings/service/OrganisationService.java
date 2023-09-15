package com.superherosightings.service;

import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;

import java.util.List;

public interface OrganisationService {
    List<SuperDto> fetchSupersByOrganisation(int organisation_id);

    List<OrganisationDto> fetchOrganisationsBySuper(int super_id);
}
