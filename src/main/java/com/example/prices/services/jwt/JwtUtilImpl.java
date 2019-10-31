package com.example.prices.services.jwt;

import com.example.prices.models.AuthPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtilImpl implements JwtUtil {
    private final ObjectMapper OM = new ObjectMapper();

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Value("${tokenId}")
    private Long tokenId;

    @Value("${tokenKey}")
    private String tokenKey;

    public String generateToken(String path) {

        String authPayload = getAuthPayload(path, tokenId);

        if (authPayload !=null) {

            // need this
            // JWT.encode(auth_payload, user_secret, 'HS256')

            return Jwts.builder()
                    .setSubject(authPayload)
                    .signWith(key)
                    .compact();

        } else {
            System.out.println("authPayload error generating");
        }

      return null;
    }

    private String getAuthPayload(String path, Long tokenId) {
        try {
            return OM.writeValueAsString(new AuthPayload(path, tokenId));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
