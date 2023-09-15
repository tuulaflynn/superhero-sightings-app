package com.superherosightings.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SuperpowerDto {
    private int superpowerId;
    private String superpowerName;
    private String superpowerDesc;
}
