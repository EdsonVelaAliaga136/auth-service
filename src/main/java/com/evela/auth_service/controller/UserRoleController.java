package com.evela.auth_service.controller;

import com.evela.auth_service.dto.UserRoleDTO;
import com.evela.auth_service.mapper.UserRoleMapper;
import com.evela.auth_service.model.UserRole;
import com.evela.auth_service.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/userRole")
public class UserRoleController {

    private final IUserRoleService userRoleService;
    private final UserRoleMapper userRoleMapper;

    @PostMapping
    public ResponseEntity<UserRoleDTO> assignRoleToUser(@RequestBody UserRoleDTO userRoleDTO) throws Exception {
        UserRole userRole = userRoleMapper.toEntity(userRoleDTO);
        UserRole userRoleCreated = userRoleService.save(userRole);
        UserRoleDTO userRoleDTOCreated = userRoleMapper.toDTO(userRoleCreated);
        return new ResponseEntity<>(userRoleDTOCreated, HttpStatus.OK);
    }
}
