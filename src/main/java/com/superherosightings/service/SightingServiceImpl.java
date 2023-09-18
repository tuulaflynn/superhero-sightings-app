package com.superherosightings.service;

import com.superherosightings.dao.LocationDao;
import com.superherosightings.dao.SightingDao;
import com.superherosightings.dao.entities.LocationEntity;
import com.superherosightings.dao.entities.SightingEntity;
import com.superherosightings.dao.entities.SuperEntity;
import com.superherosightings.model.LocationDto;
import com.superherosightings.model.SightingDto;
import com.superherosightings.model.SuperDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SightingServiceImpl implements SightingService {

    private SightingDao sightingDao;


    @Autowired
    public SightingServiceImpl(SightingDao sightingDao){
        this.sightingDao = sightingDao;
    }

    @Override
    public List<SightingDto> fetchAllSightings(){
        // save all the entities returned into a collection of sightingEntity objects
        List<SightingEntity> sightingsEntity = sightingDao.findAll();

        // for each entity in the collection, copy it to a sightingDto object
        // and add the dto object to the collection to be sent to the controller layer.
        // As the column location_id and super_id are foreign keys, spring will receive a locationEntity
        // and superEntity objects (or list of object if to-many relationship) based on the record associated with location_id and super_id respectively.
        // Inside the for loop I also need to convert the locationEntity into locationDto object and superEntity into a superDto object.
        // The relationship is many-to-one for both sighting-to-location and sighting-to-super, so only one entity will be returned in the property.
        List<SightingDto> sightingsDto = new ArrayList<>();
        sightingsEntity.forEach(sightingEntity -> {
            SightingDto sightingDto = new SightingDto();
            SuperDto superDto = new SuperDto();
            LocationDto locationDto = new LocationDto();

            // all the non-composite fields in sightingDto get assigned. Fields which are formed of composite entities will not be copy over (they are left to null).
            BeanUtils.copyProperties(sightingEntity, sightingDto);

            // convert locationEntity into locationDto and put this is locationDto property of SightingsDto
            BeanUtils.copyProperties(sightingEntity.getLocationEntity(), locationDto);
            sightingDto.setLocationDto(locationDto);

            // convert superEntity into superDto and put this is superDto property of SightingsDto
            BeanUtils.copyProperties(sightingEntity.getSuperEntity(), superDto);
            sightingDto.setSuperDto(superDto);

            sightingsDto.add(sightingDto);
        });

        return sightingsDto;
    }

    @Override
    public SightingDto addSighting(SightingDto newSightingDto) {
        SightingEntity newSightingEntity = new SightingEntity();
        LocationEntity locationEntity = new LocationEntity();
        SuperEntity superEntity = new SuperEntity();

        // setting the new dto 'sightingDto' to a new entity 'newSightingEntity'
        BeanUtils.copyProperties(newSightingDto, newSightingEntity);

        // the new entity will be mapped to a record in the database, inside this entity
        // set the location and super entity which is inside the newSightingDto. As composition objects are not automatically copied.
        BeanUtils.copyProperties(newSightingDto.getLocationDto(), locationEntity);
        newSightingEntity.setLocationEntity(locationEntity);
        BeanUtils.copyProperties(newSightingDto.getSuperDto(), superEntity);
        newSightingEntity.setSuperEntity(superEntity);

        // add the SightingEntity object to the database which is accessed by the dao which is accessed by sightingDao object.
        // As the dao has been set up extending jpa interface it has the save and flush method of Spring data Jpa to insert/update a record in the db.
        sightingDao.saveAndFlush(newSightingEntity);

        // put the updated record from the database back into sightingDto it now has a primary key
        newSightingDto.setSightingId(newSightingEntity.getSightingId());
        return newSightingDto;
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
