package com.genesysafrica.pensionr.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SignInTests {

    @Autowired
    AuthenticationService authenticationService;

    @Test
    void signInTest(){

        assertThat(authenticationService.signIn("test@gmail.com", "123456789")).isEqualTo("ORGANIZATION_CREATED");

    }

}
