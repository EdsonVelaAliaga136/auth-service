package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.MenuRoleDTO;
import com.evela.auth_service.model.MenuRole;
import com.evela.common_service.mapper.CycleAvoidingMappingContext;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
//injectionStrategy = InjectionStrategy.SETTER,
         unmappedTargetPolicy = ReportingPolicy.IGNORE ,
        uses = {MenuMapper.class, RoleMapper.class})
//uses = {CycleAvoidingMappingContext.class})
public interface MenuRoleMapper {
    MenuRoleMapper INSTANCE = Mappers.getMapper(MenuRoleMapper.class);
    MenuRoleDTO toDTO(MenuRole menuRole);
    //@Mapping(target = "version", ignore = true)
    MenuRole toEntity(MenuRoleDTO menuRoleDTO);
}
