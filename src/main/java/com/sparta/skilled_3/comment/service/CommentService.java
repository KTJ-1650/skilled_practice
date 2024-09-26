package com.sparta.skilled_3.comment.service;

import com.sparta.skilled_3.comment.dto.CommentRequestDto;
import com.sparta.skilled_3.comment.dto.CommentResponseDto;
import com.sparta.skilled_3.comment.entity.Comment;
import com.sparta.skilled_3.comment.repository.CommentRepository;
import com.sparta.skilled_3.config.exception.CustomException;
import com.sparta.skilled_3.config.exception.ErrorCode;
import com.sparta.skilled_3.schedule.entity.Schedule;
import com.sparta.skilled_3.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto createComment(Long scheduleId,CommentRequestDto commentRequestDto) {

       Schedule foundSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));

        Comment comment = new Comment(commentRequestDto);

        comment.commentGetSchedule(foundSchedule);

       Comment savedComment = commentRepository.save(comment);

       return new CommentResponseDto(savedComment);

    }

    public CommentResponseDto inquiryComment(Long commentId) {

       Comment foundComment = commentRepository.findById(commentId)
                .orElseThrow(()-> new CustomException(ErrorCode.NOT_FOUND));

       return new CommentResponseDto(foundComment);
    }

    public List<CommentResponseDto> fullInquiryComment(Long scheduleId) {

       List<Comment> comments =  commentRepository.findByScheduleId(scheduleId);

       return comments.stream().map(CommentResponseDto::new).toList();
    }


    public CommentResponseDto updateComment(Long scheduleId, Long commentId, CommentRequestDto commentRequestDto) {

       Schedule foundSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));

      Comment foundComment = commentRepository.findById(commentId)
               .orElseThrow(()-> new CustomException(ErrorCode.NOT_FOUND));

      foundComment.commentGetSchedule(foundSchedule);

      return new CommentResponseDto(foundComment);
    }
}
