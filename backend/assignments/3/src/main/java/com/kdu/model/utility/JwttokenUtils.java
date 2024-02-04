package com.kdu.model.utility;

import com.kdu.config.CustomAuthenticationManager;
import com.kdu.filters.TokenGeneratorFilter;
import com.kdu.model.dto.request.UserRegisterRequestDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwttokenUtils {
    private final CustomAuthenticationManager customAuthProvider;
    private final TokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    public JwttokenUtils(CustomAuthenticationManager customAuthProvider,
                         TokenGeneratorFilter tokenGeneratorFilter) {
        this.customAuthProvider = customAuthProvider;
        this.tokenGeneratorFilter = tokenGeneratorFilter;
    }

    public String getTokenNew(UserRegisterRequestDTO userRegisterRequestDTO){
        Authentication authentication = customAuthProvider.authenticate(
                new UsernamePasswordAuthenticationToken(userRegisterRequestDTO.getUsername(), userRegisterRequestDTO.getPassword())
        );
        return tokenGeneratorFilter.generateJWT(authentication);
    }

    public String decodeToken(String token){
        String secretKey = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return String.valueOf(claims.get("username"));
    }
}
