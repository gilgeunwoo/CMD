package com.example.cmd.exception;

public class ClassNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new ClassNotFoundException();

    private ClassNotFoundException() {
        super(ErrorCode.CLASS_NOT_FOUND);
    }
}
