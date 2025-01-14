package com.evela.auth_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionActivityLog {
    CREATED(1,"Created"),
    UPDATED(2,"Updated"),
    DELETED(3,"Deleted");

    private final Integer value;
    private final String description;
}
