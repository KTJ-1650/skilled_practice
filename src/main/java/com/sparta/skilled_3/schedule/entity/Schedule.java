package com.sparta.skilled_3.schedule.entity;

import com.sparta.skilled_3.comment.entity.Comment;
import com.sparta.skilled_3.config.timestamp.TimeStamp;
import com.sparta.skilled_3.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Comment> comments;

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
