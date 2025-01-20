package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.RolePermissionDTO;
import com.evela.auth_service.model.RolePermission;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
//injectionStrategy = InjectionStrategy.SETTER,
uses = {RoleMapper.class, PermissionMapper.class})
public interface RolePermissionMapper {
    RolePermissionMapper INSTANCE = Mappers.getMapper(RolePermissionMapper.class);
    RolePermissionDTO toDTO(RolePermission rolePermission);
    RolePermission toEntity(RolePermissionDTO rolePermissionDTO);

}
