package com.evela.auth_service.repository;

import com.evela.auth_service.model.User;
import com.evela.common_service.repository.IGenericRepo;

public interface IUserRepo extends IGenericRepo<User, Long> {
    User findOneByUsername(String username);
}
