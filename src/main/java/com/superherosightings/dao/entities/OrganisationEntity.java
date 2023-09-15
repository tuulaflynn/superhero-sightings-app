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
@Table(name = "organisation_details")
public class OrganisationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organisation_id")
    private int organisationId;

    @Column(name = "organisation_name")
    private String organisationName;

    @Column(name = "organisation_desc")
    private String organisationDesc;

    @OneToOne
    @JoinColumn(name = "organisation_contact_id")
    private OrganisationContactEntity organisationContactEntity;

    @ManyToMany
    @JoinTable(name = "superhero_organisation_details")
    private List<SuperEntity> superEntity;
}
