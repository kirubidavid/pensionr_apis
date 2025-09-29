package com.genesysafrica.pensionr.scheme.persistency;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
