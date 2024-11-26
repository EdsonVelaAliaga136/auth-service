package com.evela.auth_service.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            //return Optional.empty();
            return Optional.of("anonymous");
        }
        return Optional.of(authentication.getName());/*
        //return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
        //return Optional.of("admin");
        //return Optional.ofNullable(authentication == null ? "anonymous" : authentication.getName());
        //return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());*/
    }
}