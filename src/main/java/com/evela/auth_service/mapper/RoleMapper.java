package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.PermissionDTO;
import com.evela.auth_service.dto.RoleDTO;
import com.evela.auth_service.model.Permission;
import com.evela.auth_service.model.Role;
import com.evela.common_service.mapper.CycleAvoidingMappingContext;
import com.evela.common_service.mapper.IgnoreAuditMapping;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING,
        //injectionStrategy = InjectionStrategy.SETTER,
        //uses = {CycleAvoidingMappingContext.class})
        uses = {RolePermissionMapper.class, UserRoleMapper.class, MenuRoleMapper.class})
        //nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
        //unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    //@IgnoreAuditMapping
    //@Mapping(target = "createdAt", ignore = true)
    //@Mapping(target = "updatedAt", ignore = true)
    //@Mapping(target = "version", ignore = true)
    //@Mapping(target = "active", ignore = true)
    //@Mapping(target = "roleId", source = "roleId")
    //@Mapping(target = "roleName", source = "roleName")
    //@Mapping(target = "description", source = "description")
    //@Mapping(target = "active", source = "active")
    //@Mapping(source = "auditMetadata", target = "auditMetadata")
    @Mapping(target = "auditMetadata", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    @Mapping(target = "menuRoles", ignore = true)
    @Mapping(target = "rolePermissions", ignore = true)
    RoleDTO toDTO(Role role, @Context RolePermissionMapper rolePermissionMapper);
    //@IgnoreAuditMapping
    //@Mapping(target = "createdAt", ignore = true)
    //@Mapping(target = "updatedAt", ignore = true)
    //@Mapping(target = "version", ignore = true)
    //@Mapping(target = "active", ignore = true)
    /*@Mapping(target = "id", source = "roleId")
    @Mapping(target = "roleId", source = "roleId")
    @Mapping(target = "roleId", source = "roleId")
    @Mapping(target = "roleName", source = "roleName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "active", source = "active")*/
    //@Mapping(source = "auditMetadata", target = "auditMetadata")
    @Mapping(target = "auditMetadata", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    @Mapping(target = "menuRoles", ignore = true)
    @Mapping(target = "rolePermissions", ignore = true)
    Role toEntity(RoleDTO roleDTO, @Context RolePermissionMapper rolePermissionMapper);

}
