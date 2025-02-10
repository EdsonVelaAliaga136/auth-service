package com.evela.auth_service.controller;

import com.evela.auth_service.dto.SessionDTO;
import com.evela.auth_service.mapper.SessionMapper;
import com.evela.auth_service.model.Session;
import com.evela.auth_service.service.ISessionService;
import com.evela.auth_service.enums.SessionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionController {
    private final ISessionService sessionService;
    private final SessionMapper sessionMapper;

    @GetMapping("/status")
    public ResponseEntity<List<SessionDTO>> getSessionsByStatus(@RequestBody SessionStatus sessionStatus){
        List<SessionDTO> sessionDTOS = sessionService.findSessionsByStatus(sessionStatus).stream().map(sessionMapper::toDTO).toList();
        return new ResponseEntity<>(sessionDTOS, HttpStatus.OK);
    }
    @PostMapping("/close")
    public ResponseEntity<SessionDTO> closeSession(@RequestBody SessionDTO sessionDTO){
        Session session = sessionService.closeSessionById(sessionMapper.toEntity(sessionDTO));
        return new ResponseEntity<>(sessionMapper.toDTO(session), HttpStatus.OK);
    }
}
