package com.superherosightings.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "supertype_details")
public class SupertypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supertype_id")
    private int supertypeId;

    @Column(name = "supertype_name")
    private String supertypeName;
}
