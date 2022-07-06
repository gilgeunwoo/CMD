package com.example.cmd.controller;


import com.example.cmd.dto.request.SignUpRequest;
import com.example.cmd.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class AuthController {

    private final SignUpService signUpService;

    @PutMapping ("/signup/{secretKey}")
    public void signup(@RequestBody SignUpRequest signUpRequest, @PathVariable ("secretKey") String secretKey) {
        signUpService.signup(signUpRequest, secretKey);
    }


}
