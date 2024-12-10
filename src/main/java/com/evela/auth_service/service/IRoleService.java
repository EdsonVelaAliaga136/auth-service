package com.evela.auth_service.service;

import com.evela.auth_service.model.Role;
import com.evela.common_service.service.ICRUD;

import java.time.LocalDateTime;
import java.util.List;

public interface IRoleService extends ICRUD<Role, Long> {
    List<Role> findByCreatedByDate(LocalDateTime date);
}
