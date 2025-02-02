package com.evela.auth_service.controller;

import com.evela.auth_service.dto.SessionDTO;
import com.evela.auth_service.dto.UserSessionDTO;
import com.evela.auth_service.mapper.SessionMapper;
import com.evela.auth_service.model.Session;
import com.evela.auth_service.security.*;
import com.evela.auth_service.security.JwtRequest;
import com.evela.auth_service.security.JwtResponse;
import com.evela.auth_service.security.JwtTokenUtil;
import com.evela.auth_service.security.JwtUserDetailsService;
import com.evela.auth_service.service.ISessionService;
import com.evela.auth_service.service.IUserService;
import com.evela.common_service.enums.SessionStatus;
import com.evela.common_service.enums.Status;
import com.evela.common_service.util.DateUtils;
import com.evela.common_service.util.IpUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final IUserService userService;
    private final ISessionService sessionService;
    private final SessionMapper sessionMapper;

    @PostMapping("/login")
    public ResponseEntity<UserSessionDTO> login(@RequestBody JwtRequest jwtRequest, HttpServletRequest request)throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Session session = sessionService.saveSessionLogin(userService.findOneByUsername(jwtRequest.getUsername()), request);
        JwtResponse jwtResponse = new JwtResponse(token);
        UserSessionDTO userSessionDTO = new UserSessionDTO(jwtResponse.getJwtToken(), sessionMapper.toDTO(session));
        return new ResponseEntity<>(userSessionDTO, HttpStatus.OK);
        //return ResponseEntity.ok(new JwtResponse(token));
    }
    @PostMapping("/logout")
    public ResponseEntity<UserSessionDTO> logout(@RequestBody UserSessionDTO userSessionDTO)throws Exception {
        Session session = sessionService.saveSessionLogout(userSessionDTO.getSession().getSessionId());
        UserSessionDTO userSessionDTOResponse = new UserSessionDTO(userSessionDTO.getToken(), sessionMapper.toDTO(session));
        return new ResponseEntity<>(userSessionDTOResponse, HttpStatus.OK);
        //return ResponseEntity.ok(new JwtResponse(token));
    }

     private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
