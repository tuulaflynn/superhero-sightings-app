package com.superherosightings.service;

import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SightingDto;
import com.superherosightings.model.SuperDto;

import java.time.LocalDate;
import java.util.List;

public interface SightingService {

    List<SightingDto> fetchAllSightings();
    SightingDto addSighting(SightingDto sightingDto);

    List<SightingDto> fetchSightingByDate(LocalDate sightingDate);


}
