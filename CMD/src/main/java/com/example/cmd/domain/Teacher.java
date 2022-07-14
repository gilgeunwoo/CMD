package com.example.cmd.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Teacher {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String adminName;

    @Column(unique = true)
    private String groupNumber;

    @Column
    private String password;



    @Builder
    public Teacher(String adminName, String groupNumber, String password) {
        this.adminName = adminName;
        this.groupNumber = groupNumber;
        this.password = password;
    }

    public Teacher update(String adminName, String groupNumber) {
        this.adminName = adminName;
        this.groupNumber = groupNumber;
        return this;
    }
}
