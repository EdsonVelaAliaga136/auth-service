package com.evela.auth_service.controller;

import com.evela.auth_service.dto.PermissionDTO;
import com.evela.auth_service.mapper.PermissionMapper;
import com.evela.auth_service.model.Permission;
import com.evela.auth_service.service.IPermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Permissions")
@Validated
@RequiredArgsConstructor
public class PermissionController {
    private final IPermissionService permissionService;
    @Autowired
    private PermissionMapper permissionMapper;

    @GetMapping
    public ResponseEntity<List<PermissionDTO>> findAllPermission() throws Exception {
        List<PermissionDTO> listDTO = permissionService.findAll()
                .stream()
                .map(p->permissionMapper.toDTO(p))
                .toList();
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PermissionDTO> createPermission(@Valid @RequestBody PermissionDTO permissionDTO) throws Exception {
        Permission permission = permissionService.save(permissionMapper.toEntity(permissionDTO));
        return new ResponseEntity<>(permissionMapper.toDTO(permission), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionDTO> updatePermission(@PathVariable("id") Long id, @RequestBody PermissionDTO permissionDTO) throws Exception {
        permissionDTO.setPermissionId(id);
        Permission permission = permissionService.update(permissionMapper.toEntity(permissionDTO), id);
        return new ResponseEntity<>(permissionMapper.toDTO(permission), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> findById(@PathVariable("id") Long id) throws Exception {
        PermissionDTO permissionDTO = permissionMapper.toDTO(permissionService.findById(id));
        return new ResponseEntity<>(permissionDTO, HttpStatus.OK);
    }
}
