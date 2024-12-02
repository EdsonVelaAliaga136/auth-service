package com.evela.auth_service.controller;

import com.evela.auth_service.dto.RoleDTO;
import com.evela.auth_service.mapper.RoleMapper;
import com.evela.auth_service.model.Role;
import com.evela.auth_service.service.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
@Validated
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    @PostMapping
    public ResponseEntity<?>createRole(@Valid @RequestBody RoleDTO roleDTO)throws Exception{
        Role role = roleMapper.toEntity(roleDTO);
        roleService.save(role);
        RoleDTO roleResponseDTO = roleMapper.toDTO(role);
        return new ResponseEntity<>(roleResponseDTO, HttpStatus.CREATED);
    }
}
