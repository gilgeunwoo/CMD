package com.example.cmd.exception;

public class SecretKeyNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new SecretKeyNotFoundException();

    private SecretKeyNotFoundException() {
        super(ErrorCode.SECRET_KEY_NOT_FOUND);
    }
}
