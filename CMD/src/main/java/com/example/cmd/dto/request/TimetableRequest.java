package com.example.cmd.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class TimetableRequest {

    private String period1st;

    private String period2nd;

    private String period3th;

    private String period4th;

    private String period5th;

    private String period6th;

    private String period7th;

    private String period8th;

    private String period9th;

    private String period10th;
}
