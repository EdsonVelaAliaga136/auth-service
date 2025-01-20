package com.evela.auth_service.config;

import com.evela.auth_service.mapper.RoleMapper;
import com.evela.auth_service.mapper.RoleMapperImpl;
import com.evela.auth_service.mapper.RolePermissionMapper;
import com.evela.auth_service.mapper.RolePermissionMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MapperConfig {
    /*
    @Bean
    public RoleMapper roleMapper(RolePermissionMapper rolePermissionMapper) {
        return new RoleMapperImpl(rolePermissionMapper);
    }

    @Bean
    public RolePermissionMapper rolePermissionMapper(RoleMapper roleMapper) {
        return new RolePermissionMapperImpl(roleMapper);
    }*/
}
