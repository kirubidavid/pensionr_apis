package com.genesysafrica.pensionr.scheme;

import com.genesysafrica.pensionr.components.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/apis/v1/scheme")
public class SchemeController {

    SchemeService schemeService;

    @Autowired
    public SchemeController(SchemeService schemeService){
        this.schemeService = schemeService;
    }

    @GetMapping("/all-schemes")
    public ResponseEntity<?> getAllSchemes(@RequestParam(defaultValue = "0") int page, PagedResourcesAssembler pagedResourcesAssembler){

        var vAllSchemes = schemeService.getSchemesAssigned(UUID.randomUUID(),  PageRequest.of(page, 20));

        return ResponseHandler.generatePagedResponse("SUCCESS", HttpStatus.OK,  pagedResourcesAssembler.toModel(vAllSchemes) );
    }


}
