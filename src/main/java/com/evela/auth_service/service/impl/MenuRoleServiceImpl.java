package com.evela.auth_service.service.impl;

import com.evela.auth_service.repository.IMenuRoleRepo;
import com.evela.auth_service.service.IMenuRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuRoleServiceImpl implements IMenuRoleService {
    private final IMenuRoleRepo repo;
}
