package com.genesysafrica.pensionr.organization;

import com.genesysafrica.pensionr.organization.persistency.OrOranizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CreateOrganizationTests {

    OrganizationService organizationService;
    OrOranizationRepository orOranizationRepository;

    @Autowired
    public CreateOrganizationTests(OrganizationService organizationService, OrOranizationRepository orOranizationRepository ){
        this.orOranizationRepository = orOranizationRepository;
        this.organizationService = organizationService;
    }

    ;

    @Autowired


    @BeforeEach
    void cleanDatabase(){
        orOranizationRepository.deleteAll();
    }


    @Test
    void createOrganizationTest(){

        var VResponse = organizationService.createOrganization("ABC Limited","A0000000X",  UUID.randomUUID());

        assertThat(VResponse).isEqualTo("ORGANIZATION_CREATED");

    }


    @Test
    void createExistingOrganizationTest(){

        organizationService.createOrganization("ABC Limited","A0000000X",  UUID.randomUUID());

        var vResponse = organizationService.createOrganization("ABC Limited","A0000000X",  UUID.randomUUID());

        assertThat(vResponse).isEqualTo("ORGANIZATION_EXISTS");

    }


}
