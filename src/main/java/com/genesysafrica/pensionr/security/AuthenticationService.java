package com.genesysafrica.pensionr.security;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    Map<String,String> signIn(String vUsername, String vPassword){

        Map<String,String> response = new HashMap<>();

        return response;
    }

}
