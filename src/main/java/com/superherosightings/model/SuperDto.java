package com.superherosightings.model;

import com.superherosightings.dao.entities.OrganisationEntity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SuperDto {
    private int superId;
    private String superName;
    private String superDesc;
    private SuperpowerDto superpowerDto;
    private SupertypeDto supertypeDto;
    private List<OrganisationEntity> allOrganisationsDto;
}
