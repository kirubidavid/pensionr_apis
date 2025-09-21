package com.genesysafrica.pensionr.organization;

import com.genesysafrica.pensionr.organization.persistency.OrOranizationEntity;
import com.genesysafrica.pensionr.organization.persistency.OrOranizationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrganizationService {

    private final OrOranizationRepository orOranizationRepository;

    OrganizationService(OrOranizationRepository orOranizationRepository){
        this.orOranizationRepository = orOranizationRepository;
    }

    String createOrganization(String vOrgName, String vKraPin, UUID vUserId){

        // Check if the organization exists
        var vOrg = orOranizationRepository.findByKraPin(vKraPin).isPresent();

        if (vOrg)
            return "ORGANIZATION_EXISTS";

        var vOrganization = new OrOranizationEntity();
        vOrganization.setOrName(vOrgName);
        vOrganization.setOrTaxPin(vKraPin);
        vOrganization.setCreatedBy(vUserId);
        vOrganization.setCreatedAt(LocalDateTime.now());
        vOrganization.setUpdatedBy(vUserId);
        vOrganization.setUpdatedAt(LocalDateTime.now());
        orOranizationRepository.save(vOrganization);

        return "ORGANIZATION_CREATED";
    }

}
