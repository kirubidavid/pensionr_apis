package com.genesysafrica.pensionr.organization;

import org.springframework.stereotype.Service;

@Service
class OrganizationService {

    private final OrOranizationRepository orOranizationRepository;

    OrganizationService(OrOranizationRepository orOranizationRepository){
        this.orOranizationRepository = orOranizationRepository;
    }

    String createOrganization(){
        return "ORGANIZATION CREATED";
    }

}
