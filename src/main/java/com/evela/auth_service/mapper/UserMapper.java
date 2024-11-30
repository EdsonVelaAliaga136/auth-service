package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
