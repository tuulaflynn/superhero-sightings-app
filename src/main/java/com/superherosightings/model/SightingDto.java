package com.superherosightings.model;

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
    private LocationDto locationDto;

    @NotNull
    private SuperDto superDto;

    @NotNull
    private LocalDate sightingDate;
}
