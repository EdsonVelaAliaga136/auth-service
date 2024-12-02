package com.evela.auth_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private LocalDateTime datetime;
    private String message;
    private String path;

    /*public CustomErrorResponse(LocalDateTime datetime, String message, String path) {
        this.datetime = datetime;
        this.message = message;
        this.path = path;
    }*/
}
