package com.evela.auth_service.enums;

import com.evela.common_service.enums.EnumWithCustomValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionStatus implements EnumWithCustomValue<Integer> {
    UNDEFINED(0,"Undefined"),
    ACTIVE(1,"Active"),
    EXPIRED(2,"Expired"),
    LOGGED_OUT(3,"Logged out");

    private final Integer value;
    private final String description;
}
