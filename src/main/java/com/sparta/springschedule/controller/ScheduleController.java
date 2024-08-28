package com.sparta.springschedule.controller;

import com.sparta.springschedule.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.springschedule.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleSimpleResponseDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.springschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(scheduleSaveRequestDto));
    }

    @GetMapping
    public ResponseEntity<Page<ScheduleSimpleResponseDto>> getSchedule(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(scheduleService.getSchedules(page, size));
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, scheduleUpdateRequestDto));
    }

    @DeleteMapping("/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }

}
