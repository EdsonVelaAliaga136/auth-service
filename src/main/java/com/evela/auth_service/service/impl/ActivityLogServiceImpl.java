package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.ActivityLog;
import com.evela.auth_service.repository.IActivityLogRepo;
import com.evela.auth_service.service.IActivityLogService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl extends CRUDImpl<ActivityLog, Long> implements IActivityLogService {
    private final IActivityLogRepo repo;

    @Override
    protected IGenericRepo<ActivityLog, Long> getRepo() {
        return repo;
    }
}
