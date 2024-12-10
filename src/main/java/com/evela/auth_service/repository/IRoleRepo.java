package com.evela.auth_service.repository;

import com.evela.auth_service.dto.MenuDTO;
import com.evela.auth_service.model.Menu;
import com.evela.auth_service.model.Role;
import com.evela.common_service.repository.IGenericRepo;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IRoleRepo extends IGenericRepo<Role, Long> {

    @Query(value = """
            select r.* from roles r
            where DATE(r.created_at) = :date
            """, nativeQuery = true)
    List<Role> findByCreatedByDate(LocalDateTime date);
}
