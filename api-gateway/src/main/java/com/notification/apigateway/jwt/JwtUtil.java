package com.notification.apigateway.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean isTokenValid(String token) {
        return false;
    }

    public String extractUsername(String token) {
        return "test";
    }

    public Object extractId(String token) {
        return null;
    }

}
