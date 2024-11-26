package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Role;
import com.evela.auth_service.repository.IGenericRepo;
import com.evela.auth_service.repository.IRoleRepo;
import com.evela.auth_service.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl extends CRUDImpl<Role, Long> implements IRoleService {

    private final IRoleRepo repo;
    @Override
    protected IGenericRepo<Role, Long> getRepo() {
        return repo;
    }
}
