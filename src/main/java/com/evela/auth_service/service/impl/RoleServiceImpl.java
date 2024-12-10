package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Role;
import com.evela.auth_service.repository.IRoleRepo;
import com.evela.auth_service.service.IRoleService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl extends CRUDImpl<Role, Long> implements IRoleService {

    private final IRoleRepo repo;
    @Override
    protected IGenericRepo<Role, Long> getRepo() {
        return repo;
    }

    @Override
    public List<Role> findByCreatedByDate(LocalDateTime date) {
        return repo.findByCreatedByDate(date);
    }
}
