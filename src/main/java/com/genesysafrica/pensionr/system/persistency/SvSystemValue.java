package com.genesysafrica.pensionr.system.persistency;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sv_system_value")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SvSystemValue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "or_id_fk")
    @NotNull
    private UUID orIdFk;

    @Column(name = "sv_system_value")
    private String svSystemValue;

    @Column(name = "sv_description")
    private String svDescription;

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
