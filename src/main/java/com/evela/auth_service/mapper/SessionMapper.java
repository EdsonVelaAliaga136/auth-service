package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.SessionDTO;
import com.evela.auth_service.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class})
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    //@Mapping(target = "version", ignore = true)
    //@Mapping(target = "user.auditMetadata", ignore = true)
    //@Mapping(target = "user.version", ignore = true)
    SessionDTO toDTO(Session session);

    @Mapping(target = "version", ignore = true)
    //@Mapping(target = "user.version", ignore = true)
    //@Mapping(target = "user.auditMetadata", ignore = true)
    Session toEntity(SessionDTO session);
}
