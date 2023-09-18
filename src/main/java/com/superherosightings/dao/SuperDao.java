package com.superherosightings.dao;

import com.superherosightings.dao.entities.SuperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperDao extends JpaRepository<SuperEntity, Integer> {
}
