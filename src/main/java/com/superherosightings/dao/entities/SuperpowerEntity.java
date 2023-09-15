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
@Table(name = "superpower_details")
public class SuperpowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "superpower_id")
    private int superpowerId;

    @Column(name = "superpower_name")
    private String superpowerName;

    @Column(name = "superpower_desc")
    private String superpowerDesc;
}
