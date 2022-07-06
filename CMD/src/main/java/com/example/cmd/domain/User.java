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

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 4, nullable = false, unique = true)
    private String number;

    @Column(length = 12, nullable = false, unique = true)
    private String userId;
    @Column(length = 24, nullable = false)
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