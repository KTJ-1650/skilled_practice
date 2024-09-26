package com.sparta.skilled_3.comment.controller;

import com.sparta.skilled_3.comment.dto.CommentRequestDto;
import com.sparta.skilled_3.comment.dto.CommentResponseDto;
import com.sparta.skilled_3.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
//저장 ,단건 조회,전체 조회,수정,삭제

    @PostMapping("/{scheduleId}")
    public CommentResponseDto createComment(@PathVariable Long scheduleId,@RequestBody CommentRequestDto commentRequestDto){

        return commentService.createComment(scheduleId,commentRequestDto);
    }


    @GetMapping("/{commentId}")
    public CommentResponseDto inquiryComment(@PathVariable Long commentId){

        return commentService.inquiryComment(commentId);
    }

    @GetMapping("/schedule/{scheduleId}")
    public List<CommentResponseDto> fullInquiryComment(@PathVariable Long scheduleId){

        return commentService.fullInquiryComment(scheduleId);
    }

    @PutMapping("/schedule/{scheduleId}/comment/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long scheduleId,@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto){

        return commentService.updateComment(scheduleId,commentId,commentRequestDto);
    }





}
