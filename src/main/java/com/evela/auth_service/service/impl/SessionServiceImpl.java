package com.evela.auth_service.service.impl;

import com.evela.auth_service.model.Session;
import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.ISessionRepo;
import com.evela.auth_service.service.ISessionService;
import com.evela.common_service.enums.SessionStatus;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.ICRUD;
import com.evela.common_service.service.impl.CRUDImpl;
import com.evela.common_service.util.DateUtils;
import com.evela.common_service.util.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl extends CRUDImpl<Session, Long> implements ISessionService {
    private final ISessionRepo repo;

    @Override
    protected IGenericRepo<Session, Long> getRepo() {
        return repo;
    }

    @Override
    public Session saveSessionLogin(User user, HttpServletRequest request) {
        Session session = new Session();
        String ipAddress = IpUtils.getCLientIp(request);
        session.setIpAddress(ipAddress);
        session.setLoginTime(DateUtils.now());
        session.setUser(user);
        session.setStatus(SessionStatus.ACTIVE);
        session.setActive(true);
        //session.setVersion(0L);
        session = repo.save(session);
        return session;
    }

    @Override
    public Session saveSessionLogout(Long sessionId) {
        Optional<Session> sessionOptional = repo.findById(sessionId);
        if(sessionOptional.isPresent()){
            Session sessionUpdated = sessionOptional.get();
            sessionUpdated.setLogoutTime(DateUtils.now());
            sessionUpdated.setStatus(SessionStatus.LOGGED_OUT);
            repo.save(sessionUpdated);
            return sessionUpdated;
        }
        return null;
    }

    @Override
    public boolean closeSessions(User user) {
        //List<>
        return false;
    }

}
