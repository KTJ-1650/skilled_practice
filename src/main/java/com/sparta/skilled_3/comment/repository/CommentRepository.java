package com.sparta.skilled_3.comment.repository;

import com.sparta.skilled_3.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByScheduleId(Long scheduleId);
}
