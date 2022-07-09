package com.example.cmd.controller;

import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.dto.response.UserResponse;
import com.example.cmd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@PreAuthorize("hasAnyRole('USER')")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/timetable/{day}")
    public TimetableResponse getTimetable(@PathVariable String day) {
        return userService.getTimetable(day);
    }

    @GetMapping("/info/{number}")
    public UserResponse getUserInfo(@PathVariable String number) {
        return userService.getUserInfo(number);
    }

}
