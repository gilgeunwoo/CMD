package com.example.cmd.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String period1st;

    @Column
    private String period2nd;

    @Column
    private String period3th;

    @Column
    private String period4th;

    @Column
    private String period5th;

    @Column
    private String period6th;

    @Column
    private String period7th;

    @Column
    private String period8th;

    @Column
    private String period9th;

    @Column
    private String period10th;

    @Builder
    public Timetable(String period1st, String period2nd, String period3th, String period4th, String period5th, String period6th, String period7th, String period8th, String period9th, String period10th) {
        this.period1st = period1st;
        this.period2nd = period2nd;
        this.period3th = period3th;
        this.period4th = period4th;
        this.period5th = period5th;
        this.period6th = period6th;
        this.period7th = period7th;
        this.period8th = period8th;
        this.period9th = period9th;
        this.period10th = period10th;
    }
}
