package com.superherosightings.service;

import com.superherosightings.model.LocationDto;
import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;

import java.util.List;

public interface SuperService {
     List<LocationDto> fetchLocationsBySuper(int superId);
     List<OrganisationDto> fetchOrganisationsBySuper(int super_id);
}
