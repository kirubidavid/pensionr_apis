package com.genesysafrica.pensionr.organization_mapping.peristency;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "om_organization_mappings")
@Data
public class OmOrganizationMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "us_id_fk")
    @NotNull
    private UUID usIdFk;

    @Column(name = "or_id_fk")
    @NotNull
    private UUID orIdFk;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    @NotNull
    private UUID createdBy;

    @Column(name = "updated_at")
    @NotNull
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    @NotNull
    private UUID updatedBy;

}
