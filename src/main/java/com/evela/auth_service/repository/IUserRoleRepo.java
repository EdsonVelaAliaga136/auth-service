package com.evela.auth_service.repository;

import com.evela.auth_service.model.UserRole;
import com.evela.common_service.repository.IGenericRepo;

import java.util.List;

public interface IUserRoleRepo extends IGenericRepo<UserRole, Long> {
    List<UserRole> findByUser_UserId(Long userId);
}
