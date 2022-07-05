package com.example.cmd.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SignUpResponse {

    private String username;

    private String number;

    private String userId;

    private String password;
}
