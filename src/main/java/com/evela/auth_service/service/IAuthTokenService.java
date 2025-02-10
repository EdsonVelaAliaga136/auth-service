package com.evela.auth_service.service;

import com.evela.auth_service.model.AuthToken;
import com.evela.common_service.service.ICRUD;

public interface IAuthTokenService extends ICRUD<AuthToken, Long> {
    AuthToken saveAuthToken(String token) throws Exception;
}
