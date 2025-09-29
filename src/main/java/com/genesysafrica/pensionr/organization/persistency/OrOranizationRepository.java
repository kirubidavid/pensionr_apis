package com.genesysafrica.pensionr.organization.persistency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrOranizationRepository extends JpaRepository<OrOrganizationEntity, UUID> {

    @NativeQuery("select * from or_organizations where or_tax_pin = ?1")
    Optional<OrOrganizationEntity> findByKraPin(String vTaxPin);


    @NativeQuery("select og.* from or_organizations og left join om_organization_mappings om on og.id = om.or_id_fk where om.us_id_fk = '635b5599-e246-4038-8f59-7f5fb5525260' ")
    ArrayList<OrOrganizationEntity> findSchemesByUserId(UUID vUserId);

}
