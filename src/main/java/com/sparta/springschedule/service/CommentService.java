package com.sparta.springschedule.service;

import com.sparta.springschedule.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springschedule.dto.comment.response.CommentResponseDto;
import com.sparta.springschedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springschedule.entity.Comment;
import com.sparta.springschedule.entity.Schedule;
import com.sparta.springschedule.repository.CommentRepository;
import com.sparta.springschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long scheduleId, CommentSaveRequestDto commentSaveRequestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("일정이 없습니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getContents(), schedule);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }

    public List<CommentResponseDto> getComment() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }
}
