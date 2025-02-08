package com.evela.auth_service.repository;

import com.evela.auth_service.model.Session;
import com.evela.common_service.repository.IGenericRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISessionRepo extends IGenericRepo<Session, Long> {
    @Query("SELECT s FROM Session s WHERE s.userId = :userId AND s.status = :status")
    List<Session> findSessionByUserAndStatus(@Param("userId") Long userId, @Param("status") Integer status);

    @Query("SELECT s FROM Session s WHERE s.status = :status")
    List<Session> findSessionByStatus(@Param("status") Integer status);
}
