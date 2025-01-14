package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Permission;
import com.evela.auth_service.repository.IPermissionRepo;
import com.evela.auth_service.service.IPermissionService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl extends CRUDImpl<Permission, Long> implements IPermissionService {
    private final IPermissionRepo repo;
    @Override
    protected IGenericRepo<Permission, Long> getRepo() {
        return repo;
    }
}
