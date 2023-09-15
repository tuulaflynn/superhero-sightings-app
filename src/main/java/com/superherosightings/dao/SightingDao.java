package com.superherosightings.dao;

import com.superherosightings.dao.entities.SightingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightingDao extends JpaRepository<SightingEntity, Integer> {
    // it is a child class of JpaRepository hence we can use all of JpaRepository method (that have the correct access specifiers_
    // so all the crud operations are already taken care of in already built methods of JpaRepository
    // we give the generic of the entity which our dao class would be interacting with so the method within JpaRepository
    // can return the data from the correct table (entity).
    // The second parameter is the data type of the primary key of said table we are accessing data from,
    // through the dao which intern goes through JpaRepository method which we are able to call as SightingDao has inherited them.

}
