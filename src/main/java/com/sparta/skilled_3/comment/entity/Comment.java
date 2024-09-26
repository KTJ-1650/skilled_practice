package com.sparta.skilled_3.comment.entity;

import com.sparta.skilled_3.comment.dto.CommentRequestDto;
import com.sparta.skilled_3.config.timestamp.TimeStamp;
import com.sparta.skilled_3.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;
    private String username;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;


    public Comment(CommentRequestDto commentRequestDto){
        this.content = commentRequestDto.getContent();
        this.username = commentRequestDto.getUsername();
    }

    public void commentGetSchedule(Schedule schedule){

        this.schedule = schedule;

    }

}
