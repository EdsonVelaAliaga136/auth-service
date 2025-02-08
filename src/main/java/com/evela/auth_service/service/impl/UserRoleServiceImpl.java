package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.UserRole;
import com.evela.auth_service.repository.IUserRoleRepo;
import com.evela.auth_service.service.IUserRoleService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl extends CRUDImpl<UserRole, Long> implements IUserRoleService {
    private final IUserRoleRepo repo;

    @Override
    protected IGenericRepo<UserRole, Long> getRepo() {
        return repo;
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return repo.findByUser_UserId(userId);
    }
}
