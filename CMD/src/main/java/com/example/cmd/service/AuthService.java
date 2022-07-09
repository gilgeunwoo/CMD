package com.example.cmd.service;

import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.LoginRequest;
import com.example.cmd.dto.request.SignUpRequest;
import com.example.cmd.dto.response.TokenResponse;
import com.example.cmd.exception.AlreadyExistUserException;
import com.example.cmd.exception.InvalidPasswordException;
import com.example.cmd.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signup(SignUpRequest signUpRequest, String secretKey) {
        if (userRepository.findByUserId(signUpRequest.getUserId()).isPresent()) {
            throw AlreadyExistUserException.EXCEPTION;
        }
        User user = userRepository.findBySecretKey(secretKey)
                .orElseThrow();
        user.updateEx(signUpRequest.getUsername(),
                    signUpRequest.getNumber(),
                    signUpRequest.getUserId(),
                    passwordEncoder.encode(signUpRequest.getPassword()));
    }

    public TokenResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByUserId(loginRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디입니다."));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw InvalidPasswordException.EXCEPTION;

        return jwtTokenProvider.createToken(user.getUserId(), user.getRole());
    }
}
