package com.example.cmd.exception;

public class InvalidPasswordException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
