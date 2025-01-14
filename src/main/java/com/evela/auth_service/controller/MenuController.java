package com.evela.auth_service.controller;

import com.evela.auth_service.dto.MenuDTO;
import com.evela.auth_service.mapper.MenuMapper;
import com.evela.auth_service.model.Role;
import com.evela.auth_service.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {
    private final IMenuService menuService;
    private final MenuMapper menuMapper;

    @PostMapping("/{username}")
    public ResponseEntity<List<MenuDTO>>getMenuByUser(@RequestBody String username) throws Exception {
        List<MenuDTO> menuDTO = menuService.getMenuByUsername(username)
                .stream()
                .map(m->{
                        m.setMenuRoles(new HashSet<>());
                        return menuMapper.toDTO(m);
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(menuDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MenuDTO>>findAllMenu() throws Exception {
        List<MenuDTO> menus = menuService.findAll()
                .stream()
                .map(menuMapper::toDTO)
                .toList();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }
}
