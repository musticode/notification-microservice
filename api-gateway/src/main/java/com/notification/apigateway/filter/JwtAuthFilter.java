package com.notification.apigateway.filter;

import com.notification.apigateway.jwt.JwtUtil;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> {

    private final JwtUtil jwtUtil;

    private final List<String> whiteList = Arrays.asList(
            "/api/config-server/"
    );

    public JwtAuthFilter(JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }


    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {
           if (whiteList.contains(exchange.getRequest().getURI().getPath())){
            return chain.filter(exchange);
           }

           String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

           if (authHeader == null || !authHeader.startsWith("Bearer ")){
               exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
               return exchange.getResponse().setComplete();
           }

           String token = authHeader.substring(7);

            if (!jwtUtil.isTokenValid(token)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String userName = jwtUtil.extractUsername(token);
            String id = jwtUtil.extractId(token).toString();

            exchange.getRequest().mutate().header("sub", userName)
                    .header("user-id", id)
                    .build();

            return chain.filter(exchange);
        });
    }

    public static class Config{
    }
}


