package com.genesysafrica.pensionr.scheme;

import com.genesysafrica.pensionr.scheme.persistency.ScSchemeEntity;
import com.genesysafrica.pensionr.scheme.persistency.ScSchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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



}
