package com.superherosightings.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "super_details")
public class SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_id")
    private int superId;

    @Column(name = "super_name")
    private String superName;

    @Column(name = "super_desc")
    private String superDesc;

    @OneToMany
    @JoinColumn(name = "superpower_id")
    private List<SuperpowerEntity> superpowerEntity;

    @ManyToOne
    @JoinColumn(name = "supertype_id")
    private SupertypeEntity supertypeEntity;
}
