package com.nothing.none.security;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;


@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

  private SecretKey key() {
    return Keys.hmacShaKeyFor(
        Decoders.BASE64.decode(secret));
  }

  public String generateToken(UserDetails user) {
    Map<String, Object> claims = Map.of(
        "role",user.getAuthorities()
            .iterator().next()
            .getAuthority()
    );
    return Jwts.builder()
        .claims(claims)
        .subject(user.getUsername())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(key())
        .compact();
  }

  private Claims getClaims(String token) {
    return Jwts.parser()
        .verifyWith(key())
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  public String extractEmail(String token){
    return getClaims(token).getSubject();
  }

    private boolean isExpired(String token) {
    return getClaims(token)
        .getExpiration()
        .before(new Date());
  }

    public boolean isValid(
      String token, UserDetails user) {
    try {
      String email = extractEmail(token);
      return email.equals(user.getUsername())
          && !isExpired(token);
    } catch (JwtException e) {
      return false;
    }
  }
}
