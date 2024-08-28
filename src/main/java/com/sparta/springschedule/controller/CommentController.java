package com.sparta.springschedule.controller;

import com.sparta.springschedule.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springschedule.dto.comment.response.CommentResponseDto;
import com.sparta.springschedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springschedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long scheduleId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(scheduleId, commentSaveRequestDto);
    }

    @GetMapping("/schedules/comments")
    public List<CommentResponseDto> getComment() {
        return commentService.getComment();
    }
}
