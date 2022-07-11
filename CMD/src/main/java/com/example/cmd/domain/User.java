package com.example.cmd.domain;

import lombok.*;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Builder
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 4, unique = true)
    private String number;

    @Column(length = 12, unique = true)
    private String userId;
    
    private String password;
    @Column
    private String secretKey;
    @Column
    private Long seatNumber;

    @Column
    private String field;

    @Column
    private String birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;


    public User updateEx(String username, String number, String userId, String password) {
        this.username = username;
        this.number = number;
        this.userId = userId;
        this.password = password;
        return this;
    }

    public User update(String username, String number, String birthday, String field) {
        this.username = username;
        this.number = number;
        this.birthday = birthday;
        this.field = field;
        return this;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}