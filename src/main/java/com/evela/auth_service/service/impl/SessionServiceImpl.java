package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.AuthToken;
import com.evela.auth_service.model.Session;
import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.ISessionRepo;
import com.evela.auth_service.service.IAuthTokenService;
import com.evela.auth_service.service.ISessionService;
import com.evela.auth_service.enums.SessionStatus;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import com.evela.common_service.util.DateUtils;
import com.evela.common_service.util.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl extends CRUDImpl<Session, Long> implements ISessionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionServiceImpl.class);
    private final ISessionRepo repo;
    private final IAuthTokenService authTokenService;

    @Override
    protected IGenericRepo<Session, Long> getRepo() {
        return repo;
    }

    @Override
    public Session saveSessionLogin(User user, String token, HttpServletRequest request) throws Exception {
        Session session = new Session();
        String ipAddress = IpUtils.getCLientIp(request);
        session.setIpAddress(ipAddress);
        session.setLoginTime(DateUtils.now());
        session.setUser(user);
        session.setStatus(SessionStatus.ACTIVE);
        session.setActive(true);
        //session.setVersion(0L);
        session.setAuthToken(authTokenService.saveAuthToken(token));
        session = repo.save(session);
        LOGGER.info("Session created: {} of user: {}", session.getSessionId(), user.getUsername());
        return session;
    }

    @Override
    public Session saveSessionLogout(Long sessionId) {
        Optional<Session> sessionOptional = repo.findById(sessionId);
        if(sessionOptional.isPresent()){
            Session sessionUpdated = sessionOptional.get();
            sessionUpdated.setActive(false);
            sessionUpdated.setLogoutTime(DateUtils.now());
            sessionUpdated.setStatus(SessionStatus.LOGGED_OUT);
            repo.save(sessionUpdated);
            LOGGER.info("Session closed: {} of user: {}", sessionUpdated.getSessionId(), sessionUpdated.getUser().getUsername());
            return sessionUpdated;
        }
        return null;
    }

    @Override
    public void closeSessionsByUser(User user) {
        List<Session> lstSessionUser = this.findSessionByUserAndStatus(user, SessionStatus.ACTIVE);
        if (!lstSessionUser.isEmpty()){
            for(Session session : lstSessionUser){
               this.saveSessionLogout(session.getSessionId());
               LOGGER.info("Session closed: {} of user: {}", session.getSessionId(), user.getUsername());
            }
            LOGGER.info("All sessions closed of user: {}", user.getUsername());
        }else {
            LOGGER.info("No sessions to close of user: {}", user.getUsername());
        }
    }

    @Override
    public List<Session> findSessionByUserAndStatus(User user, SessionStatus sessionStatus) {
        return this.repo.findSessionByUserAndStatus(user, sessionStatus.getValue());
    }

    @Override
    public List<Session> findSessionsByStatus(SessionStatus sessionStatus) {
        return this.repo.findSessionByStatus(sessionStatus.getValue());
    }

    @Override
    public Session closeSessionById(Session session) {
        return this.saveSessionLogout(session.getSessionId());
    }

}
