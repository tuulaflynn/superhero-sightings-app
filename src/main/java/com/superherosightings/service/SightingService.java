package com.superherosightings.service;

import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SightingDto;
import com.superherosightings.model.SuperDto;

import java.time.LocalDate;
import java.util.List;

public interface SightingService {
    SightingDto addSighting(SightingDto sightingDto);

    List<SuperDto> fetchSupersByLocation(int locationId);

    List<LocationDto> fetchLocationsBySuper(SuperDto super_id);

    List<SightingDto> fetchSightingByDate(LocalDate sighting_date);


}
