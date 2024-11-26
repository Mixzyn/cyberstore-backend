package com.cyberstore.cyberstore.security.jwt;

import com.cyberstore.cyberstore.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.MalformedInputException;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {

    //@Value("${cyberstore.jwtSecret}")
    private String jwtSecret;

    //@Value("${cyberstore.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateToken(UserDetailsImpl userDetail) {
        return Jwts.builder().setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        }catch(MalformedJwtException e){
            System.out.println("Token inválido " + e.getMessage());
        }catch(ExpiredJwtException e){
            System.out.println("Token expirado " + e.getMessage());
        }catch(UnsupportedJwtException e){
            System.out.println("Token insuportavel " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Token inválido " + e.getMessage());
        }

        return false;
    }
}
