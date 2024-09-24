package com.sparta.skilled_3.schedule.controller;


import com.sparta.skilled_3.schedule.dto.ScheduleRequestDto;
import com.sparta.skilled_3.schedule.dto.ScheduleResponseDto;
import com.sparta.skilled_3.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/{scheduleId}")
    public ScheduleResponseDto inquirySchedule(@PathVariable Long scheduleId){

        return scheduleService.inquirySchedule(scheduleId);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long scheduleId,@RequestBody ScheduleRequestDto scheduleRequestDto){

       ScheduleResponseDto schedule = scheduleService.updateSchedule(scheduleId,scheduleRequestDto);

        return ResponseEntity.ok("수정이 완료 되었습니다");
    }
}
