package com.genesysafrica.pensionr.scheme.persistency;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sc_schemes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScSchemeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "scheme_name")
    private String schemeName;

    @Column(name = "tax_pin")
    private String taxPin;

    @Column(name = "status")
    private String status;

    @Column(name = "fund_type")
    private String fundType;

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
