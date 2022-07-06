package com.example.cmd.service;

import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.SignUpRequest;
import com.example.cmd.exception.AlreadyExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignUpRequest signUpRequest, String secretKey) {
        if (userRepository.findByUserId(signUpRequest.getUserId()).isPresent()) {
            throw AlreadyExistUserException.EXCEPTION;
        }
        User user = userRepository.findBySecretKey(secretKey)
                .orElseThrow();
        user.update(signUpRequest.getUsername(),
                    signUpRequest.getNumber(),
                    signUpRequest.getUserId(),
                    passwordEncoder.encode(signUpRequest.getPassword()));


    }
}
