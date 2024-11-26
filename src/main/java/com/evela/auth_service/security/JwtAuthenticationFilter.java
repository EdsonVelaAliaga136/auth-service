package com.evela.auth_service.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;


//@RequiredArgsConstructor/*
public class JwtAuthenticationFilter{//} extends OncePerRequestFilter {
    //@Autowired
   /* private JwtTokenProvider tokenProvider;
    String username = null;
    String token = null;
    @Override*//*
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        token = getTokenProvider(request);

        if (token != null && tokenProvider.validateToken(token)){
            try{
                username = tokenProvider.getUserNameFromJwtToken(token);

            }catch (Exception e){
                request.setAttribute("Exception", e.getMessage());
            }
            if (username!=null){

            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
   }*/
/*
   private String getTokenProvider(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
   }*/
/*
   private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.writeValueAsString(object);
    }*/
}


