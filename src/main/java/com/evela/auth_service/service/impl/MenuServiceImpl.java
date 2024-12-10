package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Menu;
import com.evela.auth_service.repository.IMenuRepo;
import com.evela.auth_service.service.IMenuService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl extends CRUDImpl<Menu, Long> implements IMenuService {
    private final IMenuRepo repo;
    @Override
    protected IGenericRepo<Menu, Long> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenuByUsername(String username) throws Exception {
        return repo.getMenuByUsername(username);
    }
}
