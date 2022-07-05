package com.example.cmd.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AdminResponse {

    private String secretKey;

    private String number;
}
