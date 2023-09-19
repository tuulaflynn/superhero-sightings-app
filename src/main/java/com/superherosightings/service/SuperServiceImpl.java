package com.superherosightings.service;

import com.superherosightings.dao.SuperDao;
import com.superherosightings.dao.entities.LocationEntity;
import com.superherosightings.dao.entities.OrganisationEntity;
import com.superherosightings.dao.entities.SightingEntity;
import com.superherosightings.dao.entities.SuperEntity;
import com.superherosightings.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperServiceImpl implements SuperService {

    SuperDao superDao;

    @Autowired
    public SuperServiceImpl(SuperDao superDao) {
        this.superDao = superDao;
    }

    @Override
    public List<LocationDto> fetchLocationsBySuper(int superId) {
        Optional<SuperEntity> superEntityOptional= superDao.findById(superId);

        // if parameter id given is valid
        if (superEntityOptional.isPresent()) {
            // put all the sightings entities, given by the mapping from superEntity to sightingEntity, into a list
            List<SightingEntity> allSightingEntity = superEntityOptional.get().getAllSightings();

            List<LocationDto> allLocationsDto = new ArrayList<LocationDto>();
            // for each sightingEntity object,
            allSightingEntity.forEach((eachSightingEntity) -> {
                LocationDto eachLocationDto = new LocationDto();
                // extract the composed locationEntity from the sightingEntity object
                LocationEntity eachLocationEntity = eachSightingEntity.getLocationEntity();
                // convert the locationEntity to a locationDto, to be passed between the layers (and in general terms to prevent cyclic referencing)
                BeanUtils.copyProperties(eachLocationEntity, eachLocationDto);
                // add the locationEntity to the list if it is not already present.
                if (!allLocationsDto.contains(eachLocationDto)) {
                    allLocationsDto.add(eachLocationDto);
                }
            });
            return allLocationsDto;
        }
        return null;
    }

    @Override
    public List<OrganisationDto> fetchOrganisationsBySuper(int super_id) {
        Optional<SuperEntity> superEntityOptional = superDao.findById(super_id);

        if (superEntityOptional.isPresent()) {
            List<OrganisationEntity> allOrganisationsEntity = superEntityOptional.get().getAllOrganisationsEntity();
            List<OrganisationDto> allOrganisationsDto = new ArrayList<>();

            allOrganisationsEntity.forEach((eachOrganisationEntity) -> {
                OrganisationDto eachOrganisationDto = new OrganisationDto();
                SupertypeDto eachSupertypeDto = new SupertypeDto();
                OrganisationContactDto eachOrganisationContactDto = new OrganisationContactDto();

                BeanUtils.copyProperties(eachOrganisationEntity, eachOrganisationDto);
                // Copy composite entities into their respective DTO objects
                BeanUtils.copyProperties(eachOrganisationEntity.getSupertypeEntity(), eachSupertypeDto);
                BeanUtils.copyProperties(eachOrganisationEntity.getOrganisationContactEntity(), eachOrganisationContactDto);
                // Set composite dto inside organisationDto
                eachOrganisationDto.setSupertypeDto(eachSupertypeDto);
                eachOrganisationDto.setOrganisationContactDto(eachOrganisationContactDto);

                allOrganisationsDto.add(eachOrganisationDto);
            });
            return allOrganisationsDto;
        }
        return null;
    }
}
