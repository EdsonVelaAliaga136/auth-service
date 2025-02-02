package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.UserRoleDTO;
import com.evela.auth_service.model.UserRole;
import com.evela.common_service.mapper.CycleAvoidingMappingContext;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//injectionStrategy = InjectionStrategy.SETTER,
        uses = {UserMapper.class, RoleMapper.class})
//uses = {CycleAvoidingMappingContext.class})
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);
    UserRoleDTO toDTO(UserRole userRole);
    //@Mapping(target = "role.version", ignore = true)
    //@Mapping(target = "version", ignore = true)
    UserRole toEntity(UserRoleDTO userRoleDTO);
}
