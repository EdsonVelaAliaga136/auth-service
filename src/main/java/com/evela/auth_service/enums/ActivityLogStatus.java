package com.evela.common_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityLogStatus {
    SUCCESS(1,"Success"),
    FAILED(2,"Failed");

    private final Integer value;
    private final String description;
}
