package com.genesysafrica.pensionr.organization_mapping;

import com.genesysafrica.pensionr.organization.UserOrganizationMappingEvent;
import com.genesysafrica.pensionr.organization_mapping.peristency.OmOrganizationMappingEntity;
import com.genesysafrica.pensionr.organization_mapping.peristency.OmOrganizationMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class UserMappingEventListener {

    @Autowired
    OmOrganizationMappingRepository omOrganizationMappingRepository;

    public UserMappingEventListener(OmOrganizationMappingRepository omOrganizationMappingRepository){
        this.omOrganizationMappingRepository = omOrganizationMappingRepository;
    }


    @ApplicationModuleListener
    void on(UserOrganizationMappingEvent userMappingEvent) throws InterruptedException{

        System.out.println("Event has been placed");

        var vOrgUserMapping = new OmOrganizationMappingEntity();
        vOrgUserMapping.setUsIdFk(userMappingEvent.vUserName());
        vOrgUserMapping.setOrIdFk(userMappingEvent.vOrgId());
        vOrgUserMapping.setCreatedBy(userMappingEvent.vCreatedBy());
        vOrgUserMapping.setUpdatedBy(userMappingEvent.vCreatedBy());
        vOrgUserMapping.setCreatedAt(LocalDateTime.now());
        vOrgUserMapping.setUpdatedAt(LocalDateTime.now());

        omOrganizationMappingRepository.save(vOrgUserMapping);

    }

}
