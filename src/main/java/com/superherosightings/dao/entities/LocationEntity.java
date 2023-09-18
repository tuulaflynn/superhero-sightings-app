package com.superherosightings.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "location_details")
public class LocationEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "location_id")
        private int locationId;

        @Column(name = "location_name")
        private String locationName;

        @Column(name = "location_desc")
        private String locationDesc;

        @Column(name = "location_address")
        private String address;

        @Column(name = "location_latitude_degree")
        private float locationLatitudeDegree;

        @Column(name = "location_longitude_degree")
        private float locationLongitudeDegree;

        @OneToMany(mappedBy = "locationEntity")
        private List<SightingEntity> allSighting;
        // This relation has been made bidirectional. It was already uni-directional
        // as everytime a SightingEntity object was retrieved it contained (composed of) a LocationEntity object,
        // which was stored in the property of SightingEntity called locationEntity.
        // This is due to the @JoinColumn annotation, and the property being joined is an object of this class,
        // hence this class has been mapped to SightingEntity. The property annotations and class type specifies the one directional mapping to the associated locationEntity.
        // Here we create a bidirectional mapping as now everytime we retrieve a locationEntity,
        // all the associated SightingEntity objects are also returned. They are stored in the property allSighting.
        // Spring JPA knows there is a mapping between SightingEntity and LocationEntity as both classes are annotated
        // with the relation (in this case, @OneToMany and @ManyToOne) and the mapping annotations
        // (@JoinColumn for one direction and mappedBy for the second) and the data types of the properties being matched to one
        // are objects of the class being mapped too.

        // Takeaways:
        // SightingEntity -> LocationEntity was the direction of the first mapping
                        // [every sightingEntity is composed of a locationEntity]
        // locationEntity -> sightingEntity was the direction of the second mapping as locationEntity was already mappedBy sightingEntity
                        // [every locationEntity is composed of a list of sightingEntity's]

}
