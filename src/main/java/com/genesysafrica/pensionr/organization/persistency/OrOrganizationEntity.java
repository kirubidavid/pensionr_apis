package com.genesysafrica.pensionr.organization.persistency;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "or_organizations")
@Data
public class OrOrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "or_name")
    @NotNull
    private String OrName;

    @Column(name = "or_tax_pin")
    @NotNull
    private String OrTaxPin;

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
