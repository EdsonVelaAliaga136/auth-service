package com.evela.auth_service.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

//@Component
public class JwtTokenProvider {
    /*@Value("${app.jwtSecret}")
    private String jwtSecret;
    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    //Generacion de token
    public String generateJwtToken(Authentication authentication){
        String username = authentication.getName();
        // Para ES512, necesitamos una clave EC (Elliptic Curve). Si tienes una clave privada EC, úsala.
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.ES512)
                .compact();
    }

    //Validacion del token
    public String getUserNameFromJwtToken(String token){
        // Crear una clave HMAC a partir de la clave secreta
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        // Usar JwtParserBuilder para crear el parser
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        // Parsear el token y obtener los claims
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        // Retornar el "subject" del JWT, que es el nombre de usuario
        return claims.getSubject();
        /*return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();*/
    //}
/*
    public boolean validateToken(String token){
        try {
            // Crear una clave HMAC a partir de la clave secreta
            Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            // Usar JwtParserBuilder para crear el parser y validar el token
            JwtParser jwtParser = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build();
            // Parsear el JWT y verificar su validez
            jwtParser.parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
    }*/
}
