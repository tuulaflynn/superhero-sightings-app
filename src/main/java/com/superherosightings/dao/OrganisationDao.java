package com.superherosightings.dao;

import com.superherosightings.dao.entities.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     // intern is annotated with @Component
public interface OrganisationDao extends JpaRepository<OrganisationEntity, Integer> {
    // See notes made in the SightingController for how this works.
}
