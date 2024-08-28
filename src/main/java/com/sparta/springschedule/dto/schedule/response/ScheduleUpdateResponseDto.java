package com.sparta.springschedule.dto.schedule.response;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public ScheduleUpdateResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
