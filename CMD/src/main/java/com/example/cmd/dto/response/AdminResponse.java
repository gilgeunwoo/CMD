package com.example.cmd.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdminResponse {

    private String secretKey;

    private String number;
}
