package com.example.cmd.exception;


public class AlreadyExistUserException extends CustomException {

    public static final CustomException EXCEPTION =
            new AlreadyExistUserException();

    private AlreadyExistUserException() {
        super(ErrorCode.USER_EXISTS);
    }
}
