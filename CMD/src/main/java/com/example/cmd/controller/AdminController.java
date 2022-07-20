package com.example.cmd.controller;

import com.example.cmd.domain.NoticeBoard;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@RestController
public class AdminController {

    private final AdminService adminService;

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(@RequestBody AdminRequest adminRequest) {
        return adminService.createSecretKey(adminRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/timetable")
    public List<Timetable> getTimetable() {
        return adminService.getTimetable();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/timetable/create")
    public String createTimetable(@RequestBody TimetableRequest timetableRequest) {
        return adminService.postTimetable(timetableRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/timetable/update/{day}")
    public void updateTimetable(@RequestBody TimetableRequest timetableRequest, @PathVariable String day) {
        adminService.updateTimetable(timetableRequest, day);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/info/update/{number}")
    public void updateUserInfo(@RequestBody UserRequest userRequest, @PathVariable String number) {
        adminService.updateUserInfo(userRequest, number);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/info/{number}")
    public UserResponse getUserInfo(@PathVariable String number) {
        return userService.getUserInfo(number);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/timetable/{day}")
    public TimetableResponse getTimetable(@PathVariable String day) {
        return userService.getTimetable(day);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/notice")
    public String postNotice(@RequestBody NoticeBoardRequest noticeBoardRequest) {
        adminService.postNotice(noticeBoardRequest);
        return "success!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/noticeBoard")
    public List<NoticeBoard> getNotice() {
        return userService.getNoticeBoard();
    }

}
