package com.evela.auth_service.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoggerUser {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerUser.class);
    public static String get(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()){
                Object principal = authentication.getPrincipal();
                if (principal instanceof UserDetails) {
                    return ((UserDetails) principal).getUsername();
                }else {
                    return principal.toString();
                }
            }else {
                LOGGER.warn("No authentication data found in security context");
                return "Unknown";
            }
        }catch(Exception e){
            LOGGER.error("Error retrieving logged user: ", e);
            return "Unknown";
        }
    }
}
