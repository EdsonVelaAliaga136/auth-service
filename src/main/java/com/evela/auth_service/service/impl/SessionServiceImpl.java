package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Session;
import com.evela.auth_service.repository.ISessionRepo;
import com.evela.auth_service.service.ISessionService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.ICRUD;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl extends CRUDImpl<Session, Long> implements ISessionService {
    private final ISessionRepo repo;

    @Override
    protected IGenericRepo<Session, Long> getRepo() {
        return repo;
    }
}
