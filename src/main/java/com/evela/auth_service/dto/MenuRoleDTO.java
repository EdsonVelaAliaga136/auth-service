package com.evela.auth_service.dto;

import com.evela.common_service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRoleDTO extends BaseDTO<Long> {
    private Long menuRoleId;
    private MenuDTO menu;
    private RoleDTO role;
}
