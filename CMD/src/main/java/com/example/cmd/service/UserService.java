package com.example.cmd.service;

import com.example.cmd.domain.TimetableRepository;
import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.UserRequest;
import com.example.cmd.dto.response.TimetableResponse;
import com.example.cmd.dto.response.UserResponse;
import com.example.cmd.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final TimetableRepository timetableRepository;

    private final UserRepository userRepository;

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


}
