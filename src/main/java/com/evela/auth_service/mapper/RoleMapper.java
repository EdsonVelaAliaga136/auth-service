package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.RoleDTO;
import com.evela.auth_service.model.Role;
import com.evela.common_service.mapper.IgnoreAuditMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    //RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    //@IgnoreAuditMapping
    //@Mapping(target = "createdAt", ignore = true)
    //@Mapping(target = "updatedAt", ignore = true)
    //@Mapping(target = "version", ignore = true)
    //@Mapping(target = "active", ignore = true)
    //@Mapping(source = "auditMetadata", target = "auditMetadata")
    //@Mapping(target = "roleId", source = "roleId")
    //@Mapping(target = "roleName", source = "roleName")
    //@Mapping(target = "description", source = "description")
    //@Mapping(target = "active", source = "active")
    RoleDTO toDTO(Role role);
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
    Role toEntity(RoleDTO roleDTO);
}
