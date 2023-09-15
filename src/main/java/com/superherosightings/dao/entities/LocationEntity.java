package com.superherosightings.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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

}
