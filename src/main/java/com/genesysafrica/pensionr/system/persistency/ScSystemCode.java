package com.genesysafrica.pensionr.system.persistency;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sc_system_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScSystemCode {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "sc_system_code")
    @NotNull
    private String scSystemCode;

    @Column(name = "sc_description")
    @NotNull
    private String scDescription;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    @NotNull
    private UUID createdBy;


}
