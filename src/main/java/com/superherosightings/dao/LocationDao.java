package com.superherosightings.dao;

import com.superherosightings.dao.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<LocationEntity, Integer> {
        // see notes made in SightingDao
}
