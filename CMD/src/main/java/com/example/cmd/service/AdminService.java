package com.example.cmd.service;

import com.example.cmd.domain.Timetable;
import com.example.cmd.domain.TimetableRepository;
import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.AdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;
    private final TimetableRepository timetableRepository;

    public String createSecretKey(AdminRequest adminRequest) {
        userRepository.save(User.builder()
                .number(adminRequest.getNumber())
                .secretKey(adminRequest.getSecretKey())
                .build());
        return "success!";
    }

    public List<Timetable> getTimetable() {
        return timetableRepository.findAll();
    }


}
