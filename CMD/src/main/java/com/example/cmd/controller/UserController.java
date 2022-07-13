package com.example.cmd.controller;

import com.example.cmd.domain.NoticeBoard;
import com.example.cmd.dto.request.UserInfoRequest;
import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.dto.response.UserResponse;
import com.example.cmd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
@RestController
public class UserController {

    private final UserService userService;


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/timetable/{day}")
    public TimetableResponse getTimetable(@PathVariable String day) {
        return userService.getTimetable(day);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/info/{number}")
    public UserResponse getUserInfo(@PathVariable String number) {
        return userService.getUserInfo(number);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/myInfoUpdate")
    public void userpersonalInfoupdate(@RequestBody UserInfoRequest userInfoRequest, @RequestHeader("Authorization") String authorization) {
        userService.updatePersonalInfo(userInfoRequest, authorization);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/noticeBoard")
    public List<NoticeBoard> getNotice() {
        return userService.getNoticeBoard();
    }
}