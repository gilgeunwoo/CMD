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

    @Column
    private String username;

    @Column
    private String number;

    @Column
    private String userId;
    @Column
    private String password;
    @Column
    private String secretKey;
    @Column
    private Long seatNumber;

    @Builder
    public User(String username, String number, String userId, String password, String secretKey, Long seatNumber) {
        this.username = username;
        this.number = number;
        this.userId = userId;
        this.password = password;
        this.secretKey = secretKey;
        this.seatNumber = seatNumber;
    }

    public User update(String username, String number, String userId, String password) {
        this.username = username;
        this.number = number;
        this.userId = userId;
        this.password = password;
        return this;

    }
}