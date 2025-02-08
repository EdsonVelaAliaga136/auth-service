package com.evela.auth_service.controller;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.dto.UserRoleDTO;
import com.evela.auth_service.exception.UserAlreadyExistsException;
import com.evela.auth_service.mapper.UserMapper;
import com.evela.auth_service.model.User;
import com.evela.auth_service.model.UserRole;
import com.evela.auth_service.service.ISessionService;
import com.evela.auth_service.service.IUserService;
import com.evela.common_service.util.LoggerUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final ISessionService sessionService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        try{
            User user = userMapper.toEntity(userDTO);
            userService.registerUser(user);
            UserDTO userResponseDTO = userMapper.toDTO(user);
            return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
            //return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } /*catch (Exception e) {
            //LoggerUtils.logError(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }*/
    }

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
    @PostMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Long id) throws Exception {
        userService.deactivateUser(id);
        sessionService.
        if(){
            return ResponseEntity<>
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
