package com.superherosightings.service;

import com.superherosightings.dao.LocationDao;
import com.superherosightings.dao.entities.LocationEntity;
import com.superherosightings.dao.entities.SightingEntity;
import com.superherosightings.model.SuperDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public List<SuperDto> fetchSupersByLocation(int locationId) {
        // Find and save the locationEntity by the parameter, locationId. It is an optional data type as the id might be invalid.
        Optional<LocationEntity> locationEntityOptional = locationDao.findById(locationId);

        if (locationEntityOptional.isPresent()) {
            // List to extract the collection of sightings from the locationEntity (as the mapping is bidirectional)
            List<SightingEntity> allSightingsEntity = locationEntityOptional.get().getAllSighting();

            // Extract the superEntity from the sightingEntity for each sightingEntity present in the collection.
            // Save these into a collection of superDtos.
            List<SuperDto> allSupersDto = new ArrayList<>();
            allSightingsEntity.forEach(eachSightingEntity -> {
                SuperDto eachSuperDto = new SuperDto();
                // convert superEntity into superDto and put this is superDto into the list allSupersDto
                BeanUtils.copyProperties(eachSightingEntity.getSuperEntity(), eachSuperDto);
                allSupersDto.add(eachSuperDto);
            });
            return allSupersDto;
        }
        return null;
    }
}
