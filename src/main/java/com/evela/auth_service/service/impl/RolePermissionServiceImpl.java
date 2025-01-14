package com.evela.auth_service.service.impl;

import com.evela.auth_service.repository.IRolePermissionRepo;
import com.evela.auth_service.service.IRolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements IRolePermissionService {
    private final IRolePermissionRepo repo;
}
