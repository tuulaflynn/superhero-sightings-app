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

    @ManyToOne
    @JoinColumn(name = "supertype_id")     // The @JoinColumn annotation works on the current table, meaning the
    // name attribute is referring to a column of organisation_details, it is specifying which column of organisation_details is a foreign key.
    // The @JoinColumn automatically links this foreign key to the primary key of the table associated with the properties data type,
    // in this case supertype_details (as we linked SupertypeEntity to this table).
    private SupertypeEntity supertypeEntity;

    @ManyToMany
    @JoinTable(name = "superhero_organisation_details",
                joinColumns = @JoinColumn(name = "organisation_id"),
            // Here as we are within the @JoinTable annotation (which specifies a table for this property to be joined to)
            // these @JoinColumn annotations refer to columns of said table.
            // They tell Spring JPA which columns of this table are foreign keys.
            // As this property is annotated with @ManyToMany (relation) and the returned data type is of type SuperEntity,
            // JPA is told that the many-to-many relation is between OrganisationEntity and SuperEntity.
            // Hence, the foreign keys given in the 'joinColumns' attribute will automatically be mapped to organisationEntity primary key
            // and the foreign key given in the 'inverseJoinColumns' attribute will automatically be mapped to the primary key
            // of the table associated with SuperEntity.
            // Hence, this property 'allSuperEntity' and annotation makes a uni directional mapping between the two entities.
                inverseJoinColumns = @JoinColumn(name = "super_id"))
    private List<SuperEntity> allSupersEntity;
}
