package com.superherosightings.model;

import com.superherosightings.dao.entities.SuperpowerEntity;
import com.superherosightings.dao.entities.SupertypeEntity;
import lombok.*;

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
}
