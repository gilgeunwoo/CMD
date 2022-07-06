package com.example.cmd.controller;

import com.example.cmd.domain.Timetable;
import com.example.cmd.dto.request.AdminRequest;
import com.example.cmd.dto.request.TimetableRequest;
import com.example.cmd.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

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
}
