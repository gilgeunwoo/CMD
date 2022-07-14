package com.example.cmd.controller;


import com.example.cmd.dto.request.MakeAdminRequest;
import com.example.cmd.service.MakeAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/OdFkV9")
public class AdminCreateController {

    private final MakeAdminService makeAdminService;

    @PostMapping("/create")
    public String createAdmin(@RequestBody MakeAdminRequest makeAdminRequest) {
        makeAdminService.createAdmin(makeAdminRequest);
        return "success!";
    }
}
