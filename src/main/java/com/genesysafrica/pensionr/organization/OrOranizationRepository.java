package com.genesysafrica.pensionr.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface OrOranizationRepository extends JpaRepository<OrOranizationEntity, UUID> {
}
