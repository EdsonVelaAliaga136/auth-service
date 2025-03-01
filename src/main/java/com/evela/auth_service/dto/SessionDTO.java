package com.evela.auth_service.dto;

import com.evela.common_service.dto.BaseDTO;
import com.evela.auth_service.enums.SessionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO extends BaseDTO<Long> {
    private Long sessionId;
    private UserDTO user;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private SessionStatus status;
    private String ipAddress;
    private AuthTokenDTO authToken;
}
