package com.genesysafrica.pensionr.system;

import com.genesysafrica.pensionr.system.persistency.ScSystemCodeRepository;
import com.genesysafrica.pensionr.system.persistency.SvSystemValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    ScSystemCodeRepository scSystemCodeRepository;

    SvSystemValueRepository svSystemValueRepository;

    @Autowired
    public SystemService(ScSystemCodeRepository scSystemCodeRepository, SvSystemValueRepository svSystemValueRepository){
        this.scSystemCodeRepository = scSystemCodeRepository;
        this.svSystemValueRepository = svSystemValueRepository;

    }




}
