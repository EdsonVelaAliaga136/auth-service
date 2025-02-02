package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.MenuRole;
import com.evela.auth_service.repository.IMenuRoleRepo;
import com.evela.auth_service.service.IMenuRoleService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuRoleServiceImpl extends CRUDImpl<MenuRole,Long> implements IMenuRoleService{
    private final IMenuRoleRepo repo;

    @Override
    protected IGenericRepo<MenuRole, Long> getRepo() {
        return repo;
    }
}
