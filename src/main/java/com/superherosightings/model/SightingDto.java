package com.superherosightings.model;

import com.superherosightings.dao.entities.LocationEntity;
import com.superherosightings.dao.entities.SuperEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SightingDto {
    private int sightingId;

    @NotNull
    private LocationEntity locationEntity;

    @NotNull
    private SuperDto superDto;

    @NotNull
    private LocalDate sightingDate;
}
