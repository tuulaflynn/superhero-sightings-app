package com.superherosightings.service;

import com.superherosightings.dao.OrganisationDao;
import com.superherosightings.model.OrganisationDto;
import com.superherosightings.model.SuperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationDao organisationDao;

    @Autowired
    public OrganisationServiceImpl(OrganisationDao organisationDao) {
        this.organisationDao = organisationDao;
    }

    @Override
    public List<SuperDto> fetchSupersByOrganisation(int organisation_id) {
        return null;
    }

    @Override
    public List<OrganisationDto> fetchOrganisationsBySuper(int super_id) {
        return null;
    }
}
