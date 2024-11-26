package com.evela.auth_service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordVerification {
        public static void main(String[] args) {
        // Crear una instancia de BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // La contraseña en texto plano ingresada por el usuario
        String rawPassword = "admin123";

        // La contraseña cifrada almacenada en la base de datos (generada previamente)
        String encodedPassword = "$2a$10$A8mPYpz5FwMhWBHBrwpV.eyAq.mjuaXB2poO4J.SXw/3l4T/Zy6EO";

        // Verificar si la contraseña ingresada coincide con la almacenada
        boolean matches = encoder.matches(rawPassword, encodedPassword);

        // Imprimir el resultado
        System.out.println("¿La contraseña coincide? " + matches);
    }
}
