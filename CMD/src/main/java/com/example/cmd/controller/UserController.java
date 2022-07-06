package com.example.cmd.controller;

import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/timetable/{day}")
    public TimetableResponse getTimetable(@PathVariable String day) {
        return userService.getTimetable(day);
    }

}
