package com.superherosightings.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LocationDto {
    private int locationId;
    private String locationName;
    private String locationDesc;
    private String address;
    private float locationLatitudeDegree;
    private float locationLongitudeDegree;
}
