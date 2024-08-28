package com.sparta.springschedule.dto.schedule.response;

import lombok.Getter;

@Getter
public class ScheduleSaveResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public ScheduleSaveResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

}
