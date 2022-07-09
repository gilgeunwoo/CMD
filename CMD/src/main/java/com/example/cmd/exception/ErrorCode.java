package com.example.cmd.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTS(409, "User Exists"),
    USER_NOT_FOUND(404, "User Not Found"),
    SECRET_KEY_NOT_FOUND(404, "Secret Key Not Found"),

    INVALID_PASSWORD(401, "Invalid Password");

    private final int status;
    private final String message;
}
