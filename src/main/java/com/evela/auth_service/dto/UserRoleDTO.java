package com.evela.auth_service.dto;

import com.evela.auth_service.model.Role;
import com.evela.auth_service.model.User;
import com.evela.common_service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO extends BaseDTO<Long> {
    private Long userRoleId;
    private UserDTO user;
    private RoleDTO role;
}
