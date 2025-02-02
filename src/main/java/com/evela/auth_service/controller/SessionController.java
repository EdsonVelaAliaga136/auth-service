package com.evela.auth_service.controller;

import com.evela.auth_service.model.Session;
import com.evela.auth_service.service.ISessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionController {
    private final ISessionService sessionService;
    /*
    public ResponseEntity<Session> createSession(Session){

    }*/
}
