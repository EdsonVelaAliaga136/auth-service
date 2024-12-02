package com.evela.auth_service.controller;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.mapper.UserMapper;
import com.evela.auth_service.model.User;
import com.evela.auth_service.service.IUserService;
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
@RequestMapping("api/Users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<?>createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User user = userMapper.toEntity(userDTO);
        userService.save(user);
        UserDTO userResponseDTO=userMapper.toDTO(user);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
