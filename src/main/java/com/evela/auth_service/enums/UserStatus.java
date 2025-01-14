package com.evela.common_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    REGISTERED(1,"Registered"),
    MODIFIED(2,"Modified"),
    CONFIRMED(3,"Confirmed"),
    DELETED(4,"Deleted"),
    LOCKED(5,"Locked"),
    PENDING(6,"Pending");

    private final Integer value;
    private final String description;

}
