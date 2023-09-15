package com.superherosightings.model;

import com.superherosightings.dao.entities.OrganisationContactEntity;
import com.superherosightings.dao.entities.SuperEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrganisationDto {
    private int organisationId;
    private String organisationName;
    private String organisationDesc;
    private OrganisationContactDto organisationContactDto;
    private SuperEntity superEntity;
}
