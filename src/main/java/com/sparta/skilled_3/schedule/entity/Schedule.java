package com.sparta.skilled_3.schedule.entity;

import com.sparta.skilled_3.config.timestamp.TimeStamp;
import com.sparta.skilled_3.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;

    public Schedule(ScheduleRequestDto scheduleRequestDto){
        this.username = scheduleRequestDto.getUsername();
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getTitle();
    }

    public void update(ScheduleRequestDto scheduleRequestDto){
        this.username = scheduleRequestDto.getUsername();
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getTitle();
    }



}
