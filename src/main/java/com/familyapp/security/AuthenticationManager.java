package com.familyapp.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public enum AuthenticationManager {
    ;

    public Authentication authenticate(UsernamePasswordAuthenticationToken authenticationToken) {
        return null;
    }

}
