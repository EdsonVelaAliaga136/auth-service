package com.evela.auth_service.enums;

import com.evela.common_service.enums.EnumWithCustomValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionActivityLog implements EnumWithCustomValue<Integer> {

    UNDEFINED(0,"Undefined"),
    CREATED(1,"Created"),
    UPDATED(2,"Updated"),
    DELETED(3,"Deleted");

    private final Integer value;
    private final String description;
}
