package com.genesysafrica.pensionr.organization;

import com.genesysafrica.pensionr.components.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/organization")
class OrganizationController {

    private final OrganizationService organizationService;

    OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @PostMapping("/create-organization")
    ResponseEntity<?> createOrganization(){

        return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, organizationService.createOrganization());
    }



}
