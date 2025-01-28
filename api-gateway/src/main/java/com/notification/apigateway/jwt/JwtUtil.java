package com.notification.apigateway.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean isTokenValid(String token) {
        //todo will be updated
        return false;
    }

    public String extractUsername(String token) {
        //todo will be updated
        return "test";
    }

    public Object extractId(String token) {
        //todo will be updated
        return null;
    }

}
