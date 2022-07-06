package com.example.cmd.service;

import com.example.cmd.domain.Timetable;
import com.example.cmd.domain.TimetableRepository;
import com.example.cmd.domain.User;
import com.example.cmd.domain.UserRepository;
import com.example.cmd.dto.request.AdminRequest;
import com.example.cmd.dto.request.TimetableRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;
    private final TimetableRepository timetableRepository;

    @Transactional
    public String createSecretKey(AdminRequest adminRequest) {
        userRepository.save(User.builder()
                .number(adminRequest.getNumber())
                .secretKey(adminRequest.getSecretKey())
                .build());
        return "success!";
    }

    @Transactional
    public List<Timetable> getTimetable() {
        return timetableRepository.findAll();
    }

    @Transactional
    public String postTimetable(TimetableRequest timetableRequest) {
        timetableRepository.save(Timetable.builder()
                .day(timetableRequest.getDay())
                .period1st(timetableRequest.getPeriod1st())
                .period2nd(timetableRequest.getPeriod2nd())
                .period3th(timetableRequest.getPeriod3th())
                .period4th(timetableRequest.getPeriod4th())
                .period5th(timetableRequest.getPeriod5th())
                .period6th(timetableRequest.getPeriod6th())
                .period7th(timetableRequest.getPeriod7th())
                .period8th(timetableRequest.getPeriod8th())
                .period9th(timetableRequest.getPeriod9th())
                .period10th(timetableRequest.getPeriod10th())
                .build());
        return "success!";
    }

    @Transactional
    public void updateTimetable(TimetableRequest request, String day) {
        timetableRepository.findByDay(day)
                .map(newTimetable -> newTimetable.update(
                        request.getPeriod1st(),
                        request.getPeriod2nd(),
                        request.getPeriod3th(),
                        request.getPeriod4th(),
                        request.getPeriod5th(),
                        request.getPeriod6th(),
                        request.getPeriod7th(),
                        request.getPeriod8th(),
                        request.getPeriod9th(),
                        request.getPeriod10th()
                ))
                .orElseThrow(RuntimeException::new);
    }


}
