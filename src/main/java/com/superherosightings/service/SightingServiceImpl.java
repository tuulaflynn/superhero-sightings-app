package com.superherosightings.service;

import com.superherosightings.dao.SightingDao;
import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SightingDto;
import com.superherosightings.model.SuperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SightingServiceImpl implements SightingService {

    private SightingDao sightingDao;

    @Autowired
    public SightingServiceImpl(SightingDao sightingDao){
        this.sightingDao = sightingDao;
    }

    @Override
    public SightingDto addSighting(SightingDto sightingDto) {
        return null;
    }

    @Override
    public List<SuperDto> fetchSupersByLocation(int locationId) {
        return null;
    }

    @Override
    public List<LocationDto> fetchLocationsBySuper(SuperDto super_id) {
        return null;
    }

    @Override
    public List<SightingDto> fetchSightingByDate(LocalDate sighting_date) {
        return null;
    }
}
