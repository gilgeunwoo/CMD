package com.example.cmd.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    Optional<Timetable> findByDay(String day);
}
