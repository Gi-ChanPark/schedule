package com.sparta.springschedule.service;

import com.sparta.springschedule.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.springschedule.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleSimpleResponseDto;
import com.sparta.springschedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.springschedule.entity.Schedule;
import com.sparta.springschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleSaveRequestDto) {
        Schedule newSchedule = new Schedule(
                scheduleSaveRequestDto.getTitle(),
                scheduleSaveRequestDto.getContents()
        );
        Schedule saveSchedule = scheduleRepository.save(newSchedule);

        return new ScheduleSaveResponseDto(saveSchedule.getId(), saveSchedule.getTitle(), saveSchedule.getContents());
    }

    public Page<ScheduleSimpleResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page -1, size);

        Page<Schedule> schedules = scheduleRepository.findAllByOrderByModifiedAtDesc(pageable);

        return schedules.map(schedule -> new ScheduleSimpleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getComments()
        ));
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long scheduleId, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("일정이 없습니다."));
        schedule.update(scheduleUpdateRequestDto.getTitle(), scheduleUpdateRequestDto.getContents());

        return new ScheduleUpdateResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }

    @Transactional
    public void deleteSchedule(Long scheduleId){
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new NullPointerException("일정이 없습니다.");
        }

        scheduleRepository.deleteById(scheduleId);
    }



}
