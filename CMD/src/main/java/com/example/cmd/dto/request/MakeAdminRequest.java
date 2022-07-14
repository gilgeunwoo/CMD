package com.example.cmd.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MakeAdminRequest {

    private String adminName;

    private String groupNumber;

    private String password;
}
