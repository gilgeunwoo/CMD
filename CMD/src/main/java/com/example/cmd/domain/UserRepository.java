package com.example.cmd.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findBySecretKey(String secretKey);

    Optional<User> findByUserId(String userId);

    Optional<User> findByNumber(String number);
}

