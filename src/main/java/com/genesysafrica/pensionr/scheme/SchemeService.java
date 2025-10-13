package com.genesysafrica.pensionr.scheme;

import com.genesysafrica.pensionr.scheme.persistency.ScSchemeEntity;
import com.genesysafrica.pensionr.scheme.persistency.ScSchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SchemeService {

    ScSchemeRepository scSchemeRepository;

    @Autowired
    public SchemeService(ScSchemeRepository scSchemeRepository){
        this.scSchemeRepository = scSchemeRepository;
    }

    public Page<ScSchemeEntity> getSchemesAssigned(UUID vUser,  Pageable pageable){
        return scSchemeRepository.getSchemesAssignedToUser(vUser, pageable);
    }

    public String createScheme(UUID vUser, String vSchemeName, String vFundType){

        var vCreateScheme = new ScSchemeEntity();
        vCreateScheme.setSchemeName(vSchemeName);
        vCreateScheme.setStatus("N");
        vCreateScheme.setFundType(vFundType);
        vCreateScheme.setCreatedAt(LocalDateTime.now());
        vCreateScheme.setUpdatedBy(vUser);
        vCreateScheme.setCreatedBy(vUser);
        vCreateScheme.setUpdatedAt(LocalDateTime.now());
        scSchemeRepository.save(vCreateScheme);

        // Send Email

        return "SCHEME_CREATED";
    }

    public String createScheme(UUID vUser, String vSchemeName, String vTaxPin, String vFundType){

        var vCreateScheme = new ScSchemeEntity();
        vCreateScheme.setSchemeName(vSchemeName);
        vCreateScheme.setStatus("N");
        vCreateScheme.setFundType(vFundType);
        vCreateScheme.setTaxPin(vTaxPin);
        vCreateScheme.setCreatedAt(LocalDateTime.now());
        vCreateScheme.setUpdatedBy(vUser);
        vCreateScheme.setCreatedBy(vUser);
        vCreateScheme.setUpdatedAt(LocalDateTime.now());
        scSchemeRepository.save(vCreateScheme);

        // Send an email

        return "SCHEME_CREATED";
    }



}
