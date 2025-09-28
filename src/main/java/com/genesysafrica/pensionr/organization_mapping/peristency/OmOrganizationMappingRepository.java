package com.genesysafrica.pensionr.organization_mapping.peristency;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OmOrganizationMappingRepository extends JpaRepository<OmOrganizationMappingEntity, UUID> {
}
