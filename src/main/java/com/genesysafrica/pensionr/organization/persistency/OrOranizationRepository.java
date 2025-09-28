package com.genesysafrica.pensionr.organization.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrOranizationRepository extends JpaRepository<OrOrganizationEntity, UUID> {

    @NativeQuery("select * from or_organizations where or_tax_pin = ?1")
    Optional<OrOrganizationEntity> findByKraPin(String vTaxPin);

}
