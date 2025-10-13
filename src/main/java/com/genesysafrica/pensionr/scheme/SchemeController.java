package com.genesysafrica.pensionr.scheme;

import com.genesysafrica.pensionr.components.ResponseHandler;
import com.genesysafrica.pensionr.scheme.dto.CreatePensionSchemeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create-pension")
    public ResponseEntity<Object> postCreatePensionScheme(@Valid @RequestBody CreatePensionSchemeDto createSchemeDto){

        var vResponse = schemeService.createScheme();

        return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, vResponse);
    }


}
