package com.genesysafrica.pensionr.scheme.persistency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ScSchemeRepository extends JpaRepository<ScSchemeEntity, UUID> {

    @NativeQuery("select * from sc_scheme")
    Page<ScSchemeEntity> getSchemesAssignedToUser(UUID vUserId, Pageable pageable);


}
