package com.genesysafrica.pensionr.security;

import com.genesysafrica.pensionr.components.ResponseHandler;
import com.genesysafrica.pensionr.security.dto.SignInDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    AuthenticationService authenticationService;

    // Sign In
    @PostMapping("/sign-in")
    public ResponseEntity<Object> signIn(SignInDto signInDto){

        var response = authenticationService.signIn(signInDto.getTxtUsername().toLowerCase().trim(), signInDto.getTxtPassword());

        return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, response);
    }

    // Sign Up

    //Reset Password



}
