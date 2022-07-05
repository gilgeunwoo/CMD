package com.example.cmd.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    private String username;

    private String number;

    private String userId;

    private String password;
}
