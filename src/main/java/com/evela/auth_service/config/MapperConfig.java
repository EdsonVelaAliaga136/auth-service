package com.evela.auth_service.config;

import com.evela.auth_service.mapper.RoleMapper;
import com.evela.auth_service.mapper.RoleMapperImpl;
import com.evela.auth_service.mapper.RolePermissionMapper;
import com.evela.auth_service.mapper.RolePermissionMapperImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MapperConfig {
/*
    @Bean
    public RoleMapper roleMapper(RolePermissionMapper rolePermissionMapper) {
        RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);
        return roleMapper;
    }

    @Bean
    public RolePermissionMapper rolePermissionMapper(RoleMapper roleMapper) {
        RolePermissionMapper rolePermissionMapper = Mappers.getMapper(RolePermissionMapper.class);
        return rolePermissionMapper;
    }*/
}
