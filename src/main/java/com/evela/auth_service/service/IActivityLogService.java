package com.evela.auth_service.service;

import com.evela.auth_service.model.ActivityLog;
import com.evela.auth_service.model.Session;
import com.evela.common_service.service.ICRUD;

import java.util.List;

public interface IActivityLogService  extends ICRUD<ActivityLog, Long> {
    List<ActivityLog> findByUser_UserId(Long userId);
}
