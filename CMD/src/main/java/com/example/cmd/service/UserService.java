package com.example.cmd.service;

import com.example.cmd.domain.*;
import com.example.cmd.dto.request.UserInfoRequest;
import com.example.cmd.dto.response.NoticeBoardResponse;
import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.dto.response.UserResponse;
import com.example.cmd.exception.UserNotFoundException;
import com.example.cmd.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final TimetableRepository timetableRepository;

    private final UserRepository userRepository;

    private final UserDetailsService userDetailsService;

    private final NoticeBoardRepository noticeBoardRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;




    @Transactional
    public TimetableResponse getTimetable(String day) {
        return timetableRepository.findByDay(day)
                .map(timetable -> {
                    TimetableResponse response = TimetableResponse.builder()
                            .day(timetable.getDay())
                            .period1st(timetable.getPeriod1st())
                            .period2nd(timetable.getPeriod2nd())
                            .period3th(timetable.getPeriod3th())
                            .period4th(timetable.getPeriod4th())
                            .period5th(timetable.getPeriod5th())
                            .period6th(timetable.getPeriod6th())
                            .period7th(timetable.getPeriod7th())
                            .period8th(timetable.getPeriod8th())
                            .period9th(timetable.getPeriod9th())
                            .period10th(timetable.getPeriod10th())
                            .build();
                    return response;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public UserResponse getUserInfo(String number) {
        return userRepository.findByNumber(number)
                .map(user -> {
                    UserResponse response = UserResponse.builder()
                            .username(user.getUsername())
                            .number(user.getNumber())
                            .birthday(user.getBirthday())
                            .field(user.getField())
                            .build();
                    return response;
                })
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public void updatePersonalInfo(UserInfoRequest userInfoRequest, String accessToken) {

        Claims claims = Jwts.parser()
                .setSigningKey(jwtTokenProvider.getSecretKey())
                .parseClaimsJws(accessToken)
                .getBody();

        User user = userRepository.findByUserId(claims.getSubject())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.updateAll(
                userInfoRequest.getUsername(),
                userInfoRequest.getNumber(),
                passwordEncoder.encode(userInfoRequest.getUserId()),
                userInfoRequest.getPassword(),
                userInfoRequest.getBirthday(),
                userInfoRequest.getField());
    }

    public List<NoticeBoard> getNoticeBoard() {
        return noticeBoardRepository.findAll();
    }
}
