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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/Users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO>createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User user = userMapper.toEntity(userDTO);
        userService.save(user);
        UserDTO userResponseDTO=userMapper.toDTO(user);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUser() throws Exception {
        List<UserDTO> listDTO = userService.findAll()
                .stream()
                .map(u->userMapper.toDTO(u))
                .toList();
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}]")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setUserId(id);
        User user = userService.update(userMapper.toEntity(userDTO), id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) throws Exception {
        UserDTO userDTO = userMapper.toDTO(userService.findById(id));
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
