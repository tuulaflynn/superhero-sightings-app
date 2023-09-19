package com.superherosightings.service;

import com.superherosightings.dao.OrganisationDao;
import com.superherosightings.dao.entities.*;
import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;
import com.superherosightings.model.SuperpowerDto;
import com.superherosightings.model.SupertypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationDao organisationDao;

    @Autowired
    public OrganisationServiceImpl(OrganisationDao organisationDao) {
        this.organisationDao = organisationDao;
    }

    @Override
    public List<SuperDto> fetchSupersByOrganisation(int organisation_id) {
        // Find the organisationEntity given by the parameter. It is an optional data type as the id might be invalid.
        Optional<OrganisationEntity> organisationEntityOptional = organisationDao.findById(organisation_id);
        //Optional<List<SuperEntity>> allSupersEntityOptional
        if (organisationEntityOptional.isPresent()) {
            // List to extract the collection of supers found in allSuperEntity property of organisationEntity object.
            // This property has been mapped to the table formed from the many-to-many relationship of supers and organisationms.
            // it gives a list of all the supers in that table which has the MATCH ON THE FOREIGN KEY? -CHECK
            List<SuperEntity> allSuperEntity = organisationEntityOptional.get().getAllSupersEntity();

            // Copy the composite properties from each superEntity into corresponding DTOs,
            // then set these to composite DTOs for each superDto.
            List<SuperDto> allSupersDto = new ArrayList<>();
            allSuperEntity.forEach(eachSuperEntity -> {
                SuperDto eachSuperDto = new SuperDto();
                SuperpowerDto eachSuperpowerDto = new SuperpowerDto();
                SupertypeDto eachSupertypeDto = new SupertypeDto();

                // convert superEntity into superDto and all composite DTOs to it.
                BeanUtils.copyProperties(eachSuperEntity, eachSuperDto);
                BeanUtils.copyProperties(eachSuperEntity.getSuperpowerEntity(), eachSuperpowerDto);
                eachSuperDto.setSuperpowerDto(eachSuperpowerDto);
                BeanUtils.copyProperties(eachSuperEntity.getSupertypeEntity(), eachSupertypeDto);
                eachSuperDto.setSupertypeDto(eachSupertypeDto);

                // Then put fully copied superDto into the list allSupersDto
                allSupersDto.add(eachSuperDto);
            });
            return allSupersDto;
        }
        return null;
    }

}
