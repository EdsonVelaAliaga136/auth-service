package com.evela.auth_service.service;

import com.evela.auth_service.model.Session;
import com.evela.auth_service.model.UserRole;
import com.evela.common_service.service.ICRUD;

import java.util.List;

public interface IUserRoleService  extends ICRUD<UserRole, Long> {
    List<UserRole> findByUserId(Long userId);
}
