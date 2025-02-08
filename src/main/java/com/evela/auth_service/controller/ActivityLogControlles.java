package com.evela.auth_service.controller;

import com.evela.auth_service.dto.ActivityLogDTO;
import com.evela.auth_service.mapper.ActivityLogMapper;
import com.evela.auth_service.model.ActivityLog;
import com.evela.auth_service.service.IActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/activityLogs")
public class ActivityLogControlles {
    private final IActivityLogService activityLogService;
    private final ActivityLogMapper activityLogMapper;

    @GetMapping("/{id}")
    private ResponseEntity<List<ActivityLogDTO>> getUserActivityLogs(@PathVariable("id") Long id){
        List<ActivityLog> lstActivityLogs = activityLogService.findByUser_UserId(id);
        List<ActivityLogDTO> lstActivityLogDTOS = lstActivityLogs.stream()
                .map(activityLogMapper::toDTO)
                .toList();
        return new ResponseEntity<>(lstActivityLogDTOS, HttpStatus.OK);
    }
}
