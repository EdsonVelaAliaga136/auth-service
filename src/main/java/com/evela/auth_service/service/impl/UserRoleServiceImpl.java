package com.evela.auth_service.service.impl;

import com.evela.auth_service.repository.IUserRoleRepo;
import com.evela.auth_service.service.IUserRoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {
    private final IUserRoleRepo repo;
}
