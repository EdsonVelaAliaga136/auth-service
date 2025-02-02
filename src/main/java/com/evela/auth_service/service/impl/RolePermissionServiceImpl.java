package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.RolePermission;
import com.evela.auth_service.repository.IRolePermissionRepo;
import com.evela.auth_service.service.IRolePermissionService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl extends CRUDImpl<RolePermission, Long> implements IRolePermissionService {
    private final IRolePermissionRepo repo;

    @Override
    protected IGenericRepo<RolePermission, Long> getRepo() {
        return repo;
    }
}
