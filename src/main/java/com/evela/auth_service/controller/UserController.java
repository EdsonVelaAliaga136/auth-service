package com.evela.auth_service.controller;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Users")
@Validated
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<?>createUser(@Valid @RequestBody UserDTO userDTO){

        iUserService.save(userDTO);
        return ResponseEntity.ok().build();
    }
}
