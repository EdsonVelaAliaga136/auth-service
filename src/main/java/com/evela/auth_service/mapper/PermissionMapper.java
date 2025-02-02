package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.PermissionDTO;
import com.evela.auth_service.model.Permission;
import com.evela.common_service.mapper.CycleAvoidingMappingContext;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
 unmappedTargetPolicy = ReportingPolicy.IGNORE ,
uses = {RolePermissionMapper.class}
//uses = {CycleAvoidingMappingContext.class}
)
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    @Mapping(target = "rolePermissions", ignore = true)
    PermissionDTO toDTO(Permission permission);
    //@Mapping(target = "version", ignore = true)
    @Mapping(target = "rolePermissions", ignore = true)
    Permission toEntity(PermissionDTO permissionDTO);
}
