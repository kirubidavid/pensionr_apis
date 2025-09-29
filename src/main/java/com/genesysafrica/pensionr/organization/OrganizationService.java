package com.genesysafrica.pensionr.organization;

import com.genesysafrica.pensionr.organization.persistency.OrOrganizationEntity;
import com.genesysafrica.pensionr.organization.persistency.OrOranizationRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional
public class OrganizationService {

    private final OrOranizationRepository orOranizationRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    OrganizationService(OrOranizationRepository orOranizationRepository, ApplicationEventPublisher applicationEventPublisher){
        this.orOranizationRepository = orOranizationRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    String createOrganization(String vOrgName, String vKraPin, UUID vUserId){

        // Check if the organization exists
        var vOrg = orOranizationRepository.findByKraPin(vKraPin).isPresent();

        if (vOrg)
            return "ORGANIZATION_EXISTS";

        var vOrganization = new OrOrganizationEntity();
        vOrganization.setOrName(vOrgName);
        vOrganization.setOrTaxPin(vKraPin);
        vOrganization.setCreatedBy(vUserId);
        vOrganization.setCreatedAt(LocalDateTime.now());
        vOrganization.setUpdatedBy(vUserId);
        vOrganization.setUpdatedAt(LocalDateTime.now());
        orOranizationRepository.save(vOrganization);

        // Map user to organization
        this.applicationEventPublisher.publishEvent(new UserOrganizationMappingEvent(vUserId, vOrganization.getId(), vUserId));


        // Send an OTP Email

        return "ORGANIZATION_CREATED";
    }

    ArrayList<OrOrganizationEntity> getSchemesAssignedToUser(UUID vUserId){
        return orOranizationRepository.findSchemesByUserId(vUserId);
    }



}
