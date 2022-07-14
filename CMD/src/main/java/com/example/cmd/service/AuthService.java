package com.example.cmd.service;

import com.example.cmd.domain.*;
import com.example.cmd.dto.request.AdminSignInRequest;
import com.example.cmd.dto.request.LoginRequest;
import com.example.cmd.dto.request.SignUpRequest;
import com.example.cmd.dto.response.TokenResponse;
import com.example.cmd.exception.*;
import com.example.cmd.exception.ClassNotFoundException;
import com.example.cmd.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final TeacherRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;



    @Transactional
    public void signup(SignUpRequest signUpRequest, String secretKey) {
        if (userRepository.findByUserId(signUpRequest.getUserId()).isPresent()) {
            throw AlreadyExistUserException.EXCEPTION;
        }
        User user = userRepository.findBySecretKey(secretKey)
                .orElseThrow();
        user.updateEx(signUpRequest.getUserId(),
                    passwordEncoder.encode(signUpRequest.getPassword()));
    }

    public TokenResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByUserId(loginRequest.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw InvalidPasswordException.EXCEPTION;

        return jwtTokenProvider.createToken(user.getUserId(), user.getRole());
    }


    public TokenResponse adminSignIn(AdminSignInRequest adminSignInRequest) {

        Teacher admin = adminRepository.findByGroupNumber(adminSignInRequest.getGroupNumber())
                .orElseThrow(() -> ClassNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(adminSignInRequest.getPassword(),admin.getPassword()))
            throw InvalidPasswordException.EXCEPTION;

        return jwtTokenProvider.createToken(admin.getGroupNumber(),Role.ROLE_ADMIN);
    }


}
