package com.example.cmd.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeBoardResponse {

    private String title;

    private String contents;

}
