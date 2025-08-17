package com.genesysafrica.pensionr.organization;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "or_organizations")
@Data
class OrOranizationEntity {

    @Id
    private UUID id;

    private String organizationName;

    private String kraPin;

    private String phoneNumber;

    private String email;

    private LocalDateTime createdAt;

    private UUID createdBy;

    private LocalDateTime updatedAt;

    private UUID updatedBy;



}
