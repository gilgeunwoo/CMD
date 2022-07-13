package com.example.cmd.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfoResponse {

    private String username;

    private String number;

    private String userId;

    private String password;

    private String birthday;

    private String field;

}
