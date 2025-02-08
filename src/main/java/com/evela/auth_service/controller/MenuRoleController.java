package com.evela.auth_service.controller;

import com.evela.auth_service.dto.MenuRoleDTO;
import com.evela.auth_service.dto.RolePermissionDTO;
import com.evela.auth_service.mapper.MenuRoleMapper;
import com.evela.auth_service.mapper.RolePermissionMapper;
import com.evela.auth_service.model.MenuRole;
import com.evela.auth_service.model.RolePermission;
import com.evela.auth_service.service.IMenuRoleService;
import com.evela.auth_service.service.IMenuService;
import com.evela.auth_service.service.IRolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menuRole")
@RequiredArgsConstructor
public class MenuRoleController {
     private final IMenuRoleService menuRoleService;
    private final MenuRoleMapper menuRoleMapper;

    @PostMapping("/assignMenuToRole")
    public ResponseEntity<MenuRoleDTO> assignMenuToRole(@RequestBody MenuRoleDTO menuRoleDTO) throws Exception {
        MenuRole menuRoleCreated = menuRoleService.save(menuRoleMapper.toEntity(menuRoleDTO));
        return new ResponseEntity<>(menuRoleMapper.toDTO(menuRoleCreated), HttpStatus.CREATED);
    }

}
