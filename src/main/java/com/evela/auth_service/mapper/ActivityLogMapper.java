package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.ActivityLogDTO;
import com.evela.auth_service.model.ActivityLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class})
public interface ActivityLogMapper {
    ActivityLogMapper INSTANCE = Mappers.getMapper(ActivityLogMapper.class);
    ActivityLogDTO toDTO(ActivityLog activityLog);
    ActivityLog toEntity(ActivityLogDTO activityLogDTO);
}
