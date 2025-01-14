package com.evela.auth_service.dto;

import com.evela.auth_service.model.Permission;
import com.evela.auth_service.model.Role;
import com.evela.common_service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionDTO extends BaseDTO<Long> {
    private Long rolePermissionId;
    private RoleDTO role;
    private PermissionDTO permission;
}
