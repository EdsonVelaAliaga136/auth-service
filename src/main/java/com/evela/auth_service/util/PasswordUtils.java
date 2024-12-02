package com.evela.auth_service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    public static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return encoder.encode(password);
    }

    public static boolean matches(String rawPassword, String encodePassword){
        return encoder.matches(rawPassword, encodePassword);
    }
}
