package com.evela.auth_service.controller;

import com.evela.auth_service.dto.RoleDTO;
import com.evela.auth_service.mapper.RoleMapper;
import com.evela.auth_service.model.Role;
import com.evela.auth_service.service.IRoleService;
import com.evela.common_service.exception.OptimisticLockException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/roles")
@Validated
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    private final RoleMapper roleMapper;
/*
    @Autowired
    public RoleController(IRoleService roleService, @Lazy RoleMapper roleMapper){
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }
*/
    @GetMapping
    public ResponseEntity<List<RoleDTO>>findAllRole() throws Exception {
        List<RoleDTO> rolesDTO = roleService.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList();
        return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDTO>createRole(@Valid @RequestBody RoleDTO roleDTO)throws Exception{
        Role role = roleMapper.toEntity(roleDTO);
        role.setActive(true);
        roleService.save(role);
        RoleDTO roleResponseDTO = roleMapper.toDTO(role);
        return new ResponseEntity<>(roleResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO>updateRole(@PathVariable("id") Long id, @Valid @RequestBody RoleDTO roleDTO) throws Exception {
        try{
            roleDTO.setRoleId(id);
            Role role = roleService.update(roleMapper.toEntity(roleDTO), id);
            return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
        }catch (OptimisticLockException e){
            throw new RuntimeException("Entity was updated concurrently. Please try again.", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable("id") Long id) throws Exception {
        RoleDTO roleDTO = roleMapper.toDTO(roleService.findById(id));
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

    /*@PostMapping("/date")
    public ResponseEntity<List<RoleDTO>> findById(@RequestBody RoleDTO date) throws Exception {
        List<RoleDTO> rolesDTO = roleService.findByCreatedByDate(date.getAuditMetadata().getCreatedAt())
                .stream()
                .map(roleMapper::toDTO)
                .toList();
        return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
    }*/

}
