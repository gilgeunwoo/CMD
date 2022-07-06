package com.example.cmd.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 4, unique = true)
    private String number;

    @Column(length = 12, unique = true)
    private String userId;
    @Column(length = 24)
    private String password;
    @Column
    private String secretKey;
    @Column
    private Long seatNumber;

    @Column
    private String field;

    @Column
    private String birthday;

    @Builder
    public User(String birthday, String field, String username, String number, String userId, String password, String secretKey, Long seatNumber) {
        this.birthday = birthday;
        this.field = field;
        this.username = username;
        this.number = number;
        this.userId = userId;
        this.password = password;
        this.secretKey = secretKey;
        this.seatNumber = seatNumber;
    }

    public User update(String username, String number, String birthday, String field) {
        this.username = username;
        this.number = number;
        this.birthday = birthday;
        this.field = field;
        return this;

    }


}