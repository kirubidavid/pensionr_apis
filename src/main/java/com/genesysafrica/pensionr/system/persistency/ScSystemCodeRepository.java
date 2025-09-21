package com.genesysafrica.pensionr.system.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScSystemCodeRepository extends JpaRepository<ScSystemCode, UUID> {
}
