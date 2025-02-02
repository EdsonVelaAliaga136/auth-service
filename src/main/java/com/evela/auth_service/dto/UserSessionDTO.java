package com.evela.auth_service.dto;

import com.evela.auth_service.security.JwtResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude
public class UserSessionDTO {
    private String token;
    private SessionDTO session;
}
