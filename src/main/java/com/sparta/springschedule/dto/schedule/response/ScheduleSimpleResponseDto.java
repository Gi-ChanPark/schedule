package com.sparta.springschedule.dto.schedule.response;

import com.sparta.springschedule.dto.comment.response.CommentResponseDto;
import com.sparta.springschedule.entity.Comment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleSimpleResponseDto {

    private final Long id;
    private final String title;
    private final List<CommentResponseDto> comments;

    public ScheduleSimpleResponseDto(Long id, String title, List<Comment> comments) {
        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        this.id = id;
        this.title = title;
        this.comments = dtoList;
    }

}
