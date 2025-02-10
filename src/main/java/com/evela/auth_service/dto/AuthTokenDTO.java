package com.evela.auth_service.dto;

import com.evela.common_service.dto.BaseDTO;
import com.evela.common_service.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokenDTO extends BaseDTO<Long> {
    private Long authTokenId;
    private LocalDateTime expirationDate;
    private String username;
    private Status status;
    private String token;
}
