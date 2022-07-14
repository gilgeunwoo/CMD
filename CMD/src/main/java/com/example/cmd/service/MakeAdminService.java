package com.example.cmd.service;

import com.example.cmd.domain.Teacher;
import com.example.cmd.domain.TeacherRepository;
import com.example.cmd.dto.request.MakeAdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MakeAdminService {

    private final TeacherRepository teacherRepository;

    private final PasswordEncoder passwordEncoder;

    public String createAdmin(MakeAdminRequest makeAdminRequest) {
        teacherRepository.save(Teacher.builder()
                        .adminName(makeAdminRequest.getAdminName())
                        .groupNumber(makeAdminRequest.getGroupNumber())
                        .password(passwordEncoder.encode(makeAdminRequest.getPassword()))
                        .build());
        return "success!";
    }
}
