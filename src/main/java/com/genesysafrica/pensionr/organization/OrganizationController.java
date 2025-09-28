package com.genesysafrica.pensionr.organization;

import com.genesysafrica.pensionr.components.ResponseHandler;
import com.genesysafrica.pensionr.organization.dto.CreateOrganizationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/apis/v1/organization")
class OrganizationController {

    private final OrganizationService organizationService;

    OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @PostMapping("/create-organization")
    ResponseEntity<Object> createOrganization(@RequestBody CreateOrganizationDto createOrganizationDto){

        var vResponse = organizationService.createOrganization(createOrganizationDto.getTxtOrganizationName(),createOrganizationDto.getTxtTaxPin(),  UUID.randomUUID());

        return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, vResponse);
    }




}
