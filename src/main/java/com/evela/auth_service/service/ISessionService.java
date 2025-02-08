package com.evela.auth_service.service;

import com.evela.auth_service.model.Session;
import com.evela.auth_service.model.User;
import com.evela.common_service.enums.SessionStatus;
import com.evela.common_service.service.ICRUD;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ISessionService extends ICRUD<Session, Long> {
    Session saveSessionLogin(User user, HttpServletRequest request);
    Session saveSessionLogout(Long sessionId);
    void closeSessionsByUser(User user);
    List<Session> findSessionByUserAndStatus(Long userId, SessionStatus sessionStatus);
    List<Session> findSessionsByStatus(SessionStatus sessionStatus);
    Session closeSessionById(Session session);
}
