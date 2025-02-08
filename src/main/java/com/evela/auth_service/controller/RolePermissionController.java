package com.evela.auth_service.controller;

import com.evela.auth_service.dto.RolePermissionDTO;
import com.evela.auth_service.mapper.RolePermissionMapper;
import com.evela.auth_service.model.Permission;
import com.evela.auth_service.model.Role;
import com.evela.auth_service.model.RolePermission;
import com.evela.auth_service.service.IRolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rolePermission")
@RequiredArgsConstructor
public class RolePermissionController {
    private final IRolePermissionService rolePermissionService;
    private final RolePermissionMapper rolePermissionMapper;

    @PostMapping("/assignRolePermission")
    public ResponseEntity<RolePermissionDTO> assignRoleToPermission(@RequestBody RolePermissionDTO rolePermissionDTO) throws Exception {
        RolePermission rolePermissionCreated = rolePermissionService.save(rolePermissionMapper.toEntity(rolePermissionDTO));
        return new ResponseEntity<>(rolePermissionMapper.toDTO(rolePermissionCreated), HttpStatus.CREATED);
    }

   //public ResponseEntity<RolePermissionDTO> assignPermissionToRole(@RequestBody RolePermissionDTO rolePermissionDTO) throws Exception {}



}
