package com.example.cmd.controller;

import com.example.cmd.domain.Timetable;
import com.example.cmd.dto.request.AdminRequest;
import com.example.cmd.dto.request.NoticeBoardRequest;
import com.example.cmd.dto.request.TimetableRequest;
import com.example.cmd.dto.request.UserRequest;
import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.dto.response.UserResponse;
import com.example.cmd.service.AdminService;
import com.example.cmd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    private final UserService userService;

    @PostMapping("/create")
    public String create(@RequestBody AdminRequest adminRequest) {
        return adminService.createSecretKey(adminRequest);
    }

    @GetMapping("/timetable")
    public List<Timetable> getTimetable() {
        return adminService.getTimetable();
    }

    @PostMapping("/timetable/create")
    public String createTimetable(@RequestBody TimetableRequest timetableRequest) {
        return adminService.postTimetable(timetableRequest);
    }

    @PatchMapping("/timetable/update/{day}")
    public void updateTimetable(@RequestBody TimetableRequest timetableRequest, @PathVariable String day) {
        adminService.updateTimetable(timetableRequest, day);
    }

    @PutMapping("/info/update/{number}")
    public void updateUserInfo(@RequestBody UserRequest userRequest, @PathVariable String number) {
        adminService.updateUserInfo(userRequest, number);
    }

    @GetMapping("/info/{number}")
    public UserResponse getUserInfo(@PathVariable String number) {
        return userService.getUserInfo(number);
    }

    @GetMapping("/timetable/{day}")
    public TimetableResponse getTimetable(@PathVariable String day) {
        return userService.getTimetable(day);
    }

    @PostMapping("/notice")
    public String postNotice(@RequestBody NoticeBoardRequest noticeBoardRequest) {
        adminService.postNotice(noticeBoardRequest);
        return "success!";
    }
}
