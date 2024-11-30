package com.evela.auth_service.repository;

import com.evela.auth_service.model.Role;
import com.evela.common_service.repository.IGenericRepo;
import org.springframework.stereotype.Repository;

public interface IRoleRepo extends IGenericRepo<Role, Long> {
}
