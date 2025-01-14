package com.evela.common_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionStatus {
    ACTIVE(1,"Active"),
    EXPIRED(2,"Expired"),
    LOGGED_OUT(3,"Logged out");

    private final Integer value;
    private final String description;
}
