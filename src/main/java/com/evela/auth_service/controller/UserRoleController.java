package com.evela.auth_service.controller;

import com.evela.auth_service.dto.UserRoleDTO;
import com.evela.auth_service.mapper.UserRoleMapper;
import com.evela.auth_service.model.UserRole;
import com.evela.auth_service.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/userRole")
public class UserRoleController {

    private final IUserRoleService userRoleService;
    private final UserRoleMapper userRoleMapper;

    @PostMapping("/assignRoleToUser")
    public ResponseEntity<UserRoleDTO> assignRoleToUser(@RequestBody UserRoleDTO userRoleDTO) throws Exception {
        UserRole userRole = userRoleMapper.toEntity(userRoleDTO);
        UserRole userRoleCreated = userRoleService.save(userRole);
        UserRoleDTO userRoleDTOCreated = userRoleMapper.toDTO(userRoleCreated);
        return new ResponseEntity<>(userRoleDTOCreated, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/getUserRoles")
    public ResponseEntity<List<UserRoleDTO>> getUserRoles(@PathVariable("id") Long userId){
        List<UserRoleDTO> userRoleDTOS = userRoleService.findByUserId(userId)
                .stream().map(userRoleMapper::toDTO).toList();
        return new ResponseEntity<>(userRoleDTOS, HttpStatus.OK);
    }
}
