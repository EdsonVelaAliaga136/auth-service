package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.AuthToken;
import com.evela.auth_service.repository.IAuthTokenRepo;
import com.evela.auth_service.security.JwtTokenUtil;
import com.evela.auth_service.service.IAuthTokenService;
import com.evela.common_service.enums.Status;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import com.evela.common_service.util.DateUtils;
import com.evela.common_service.validator.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthTokenServiceImpl extends CRUDImpl<AuthToken, Long> implements IAuthTokenService {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthTokenServiceImpl.class);
    private final IAuthTokenRepo repo;
    private final JwtTokenUtil jwtTokenUtil;
    @Override
    protected IGenericRepo<AuthToken, Long> getRepo() {
        return repo;
    }

    @Override
    public AuthToken saveAuthToken(String token) throws Exception {
        if (ValidationUtils.isNotNull(token)){
            AuthToken authToken = new AuthToken();
            authToken.setToken(token);
            authToken.setExpirationDate(DateUtils.convertToLocalDateTime(jwtTokenUtil.getExpirationDateFromToken(token)));
            authToken.setUsername(jwtTokenUtil.getUsernameFromToken(token));
            authToken.setStatus(Status.ACTIVE);
            this.save(authToken);
            LOGGER.info("Saved auth token");
            return authToken;
        }
        LOGGER.error("Token is null");
        return null;
    }
}
