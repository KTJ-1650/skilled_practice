package com.sparta.skilled_3.schedule.repository;

import com.sparta.skilled_3.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
