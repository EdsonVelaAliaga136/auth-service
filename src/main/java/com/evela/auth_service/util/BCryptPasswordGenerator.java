package com.evela.auth_service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {
        public static void main(String[] args) {
        // Crear una instancia de BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // La contraseña sin cifrar
        String rawPassword = "admin123";

        // Generar la contraseña cifrada con BCrypt
        String encodedPassword = encoder.encode(rawPassword);

        // Imprimir la contraseña cifrada
        System.out.println("Contraseña cifrada: " + encodedPassword);
    }
}
