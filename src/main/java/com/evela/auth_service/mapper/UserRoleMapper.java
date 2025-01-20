package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.UserRoleDTO;
import com.evela.auth_service.model.UserRole;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
//injectionStrategy = InjectionStrategy.SETTER,
uses = {UserMapper.class, RoleMapper.class})
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);
    UserRoleDTO toDTO(UserRole userRole);
    UserRole toEntity(UserRoleDTO userRoleDTO);
}
