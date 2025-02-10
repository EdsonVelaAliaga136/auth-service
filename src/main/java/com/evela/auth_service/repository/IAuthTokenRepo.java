package com.evela.auth_service.repository;

import com.evela.auth_service.model.AuthToken;
import com.evela.common_service.repository.IGenericRepo;

public interface IAuthTokenRepo extends IGenericRepo<AuthToken, Long> {
}
