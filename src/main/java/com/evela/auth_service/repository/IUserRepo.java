package com.evela.auth_service.repository;

import com.evela.auth_service.model.User;

public interface IUserRepo extends IGenericRepo<User, Long>{
    User findOneByUsername(String username);
}
