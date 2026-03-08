package com.example.demo.security;

import com.example.demo.constants.ApplicationConstants;
import com.example.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtHelper {

    public <T> T extractClaims(String jwt, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    //this method is used to extract the username from the jwt token
    public String extractUsername(String jwt) {
        return extractClaims(jwt, Claims::getSubject);
    }

    public String generateAccessToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("role", ((User) userDetails).getRole().name());
        return doGenerateAccessToken(claims, userDetails.getUsername());
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return doGenerateRefreshToken(userDetails.getUsername());
    }

    private String doGenerateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject("#refresh"+username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ ApplicationConstants.ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .setId(UUID.randomUUID().toString())
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private String doGenerateAccessToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ApplicationConstants.ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(getSignInKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsername(jwt);
        return (username.equals(userDetails.getUsername())) &&
//                extractClaims(jwt, Claims::getSubject).equals(username)
                !isJwtExpired(jwt);
    }

    public boolean isRefreshTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsername(jwt).substring(8);
        return (username.equals(userDetails.getUsername())) && !isJwtExpired(jwt);
    }

    private boolean isJwtExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }

    private Date extractExpiration(String jwt){
        return extractClaims(jwt, Claims ->Claims.getExpiration());
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
    
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(ApplicationConstants.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
