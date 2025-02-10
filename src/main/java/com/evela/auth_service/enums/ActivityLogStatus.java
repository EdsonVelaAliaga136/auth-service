package com.evela.auth_service.enums;

import com.evela.common_service.enums.EnumWithCustomValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityLogStatus implements EnumWithCustomValue<Integer> {

    UNDEFINED(0,"Undefined"),
    SUCCESS(1,"Success"),
    FAILED(2,"Failed");

    private final Integer value;
    private final String description;
}
