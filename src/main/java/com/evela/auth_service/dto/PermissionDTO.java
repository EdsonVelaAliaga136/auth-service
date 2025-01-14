package com.evela.auth_service.dto;

import com.evela.common_service.dto.BaseDTO;
import com.evela.common_service.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO extends BaseDTO<Long> {
    private Long permissionId;
    private String name;
    private String description;
    private Set<RolePermissionDTO> rolePermission;
    private Status status;
}
