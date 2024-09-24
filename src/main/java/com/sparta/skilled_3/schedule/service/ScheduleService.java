package com.sparta.skilled_3.schedule.service;

import com.sparta.skilled_3.config.exception.CustomException;
import com.sparta.skilled_3.config.exception.ErrorCode;
import com.sparta.skilled_3.schedule.dto.ScheduleRequestDto;
import com.sparta.skilled_3.schedule.dto.ScheduleResponseDto;
import com.sparta.skilled_3.schedule.entity.Schedule;
import com.sparta.skilled_3.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {

        Schedule schedule = new Schedule(scheduleRequestDto);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }


    public ScheduleResponseDto inquirySchedule(Long scheduleId) {

       Schedule foundSchedule  = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));


       return new ScheduleResponseDto(foundSchedule);
    }


    public ScheduleResponseDto updateSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto) {

      Schedule schedule =  scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new CustomException(ErrorCode.NOT_FOUND));

        schedule.update(scheduleRequestDto);

        return new ScheduleResponseDto(schedule);
    }


}
