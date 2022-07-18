package com.example.cmd.service;

import com.example.cmd.domain.Role;
import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.MakeAdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MakeAdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String createAdmin(MakeAdminRequest makeAdminRequest) {
        userRepository.save(User.builder()
                        .username(makeAdminRequest.getAdminName())
                        .userId(makeAdminRequest.getGroupNumber())
                        .password(passwordEncoder.encode(makeAdminRequest.getPassword()))
                        .role(Role.ROLE_ADMIN)
                        .secretKey("teacher1")
                        .number(makeAdminRequest.getGroupNumber())
                        .birthday("teacher2")
                        .field("teacher3")
                        .build());
        return "success!";
    }
}
