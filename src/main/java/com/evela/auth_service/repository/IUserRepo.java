package com.evela.auth_service.repository;

import com.evela.auth_service.model.User;
import com.evela.common_service.repository.IGenericRepo;
import org.springframework.stereotype.Repository;

//@Repository
public interface IUserRepo extends IGenericRepo<User, Long> {
    User findOneByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
