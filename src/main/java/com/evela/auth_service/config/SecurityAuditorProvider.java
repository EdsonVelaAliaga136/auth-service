package com.evela.auth_service.config;

import com.evela.common_service.audit.AuditorAwareProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorProvider implements AuditorAwareProvider {
    @Override
    public String getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            return "system";
        }
        //Obtener el nombre de usuario desde el token jwt
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }else{
            return principal.toString();
        }
    }
}
