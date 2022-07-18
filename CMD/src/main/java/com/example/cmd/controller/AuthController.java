package com.example.cmd.controller;


import com.example.cmd.dto.request.AdminSignInRequest;
import com.example.cmd.dto.request.LoginRequest;
import com.example.cmd.dto.request.SignUpRequest;
import com.example.cmd.dto.response.SignUpResponse;
import com.example.cmd.dto.response.TokenResponse;
import com.example.cmd.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping ("/signup/{secretKey}")
    public SignUpResponse signup(@RequestBody SignUpRequest signUpRequest, @PathVariable ("secretKey") String secretKey) {
        return authService.signup(signUpRequest, secretKey);
    }

    @PostMapping("/signin")
    public TokenResponse signin(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @PostMapping("/signina")
    public TokenResponse adminSignin(@RequestBody AdminSignInRequest adminSignInRequest) {
        return authService.adminSignIn(adminSignInRequest);
    }

}
