package com.superherosightings.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "sighting_details")
public class SightingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sighting_id")
    private int sightingId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity locationEntity;

    @ManyToOne
    @JoinColumn(name = "super_id")
    private SuperEntity superEntity;

    @Column(name = "sighting_date")
    private LocalDate sightingDate;
}
