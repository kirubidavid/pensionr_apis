package com.genesysafrica.pensionr.scheme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CreatePensionSchemeTests {

    SchemeService schemeService;

    @Autowired
    public CreatePensionSchemeTests(SchemeService schemeService){
        this.schemeService = schemeService;
    }

    @Test
    void createPensionSchemeTest(){
       var vResponse = schemeService.createScheme(UUID.randomUUID(),"Personal Pension Plan", "P00000000X", "10001");

        assertThat(vResponse).isEqualTo("SCHEME_CREATED");
    }

}
