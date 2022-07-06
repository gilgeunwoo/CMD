package com.example.cmd.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    private String username;

    private String number;

    private String birthday;

    private String field;
}
