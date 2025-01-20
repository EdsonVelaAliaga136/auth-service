package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.PermissionDTO;
import com.evela.auth_service.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {RolePermissionMapper.class})
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toDTO(Permission permission);
    Permission toEntity(PermissionDTO permissionDTO);
}
