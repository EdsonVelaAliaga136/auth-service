package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.IUserRepo;
import com.evela.auth_service.service.IUserService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl extends CRUDImpl<User, Long> implements IUserService {

    private final IUserRepo repo;
    @Override
    protected IGenericRepo<User, Long> getRepo() {
        return repo;
    }
}
