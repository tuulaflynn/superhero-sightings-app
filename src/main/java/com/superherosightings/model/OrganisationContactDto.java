package com.superherosightings.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrganisationContactDto {
    private int organisationContactId;
    private String address;
    private String zipcode;
    private String phoneNumber;
}
