package com.example.cmd.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @Builder
    public NoticeBoard(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public NoticeBoard update(String title, String contents) {
        this.title = title;
        this.contents = contents;

        return this;
    }
}
