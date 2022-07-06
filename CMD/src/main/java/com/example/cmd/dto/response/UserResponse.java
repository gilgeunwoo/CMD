package com.example.cmd.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String username;

    private String number;

    private String birthday;

    private String field;
}
