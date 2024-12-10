package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.MenuDTO;
import com.evela.auth_service.model.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
    //@Mapping(source = "auditMetadata", target = "auditMetadata")
    MenuDTO toDTO(Menu menu);
    //@Mapping(source = "auditMetadata", target = "auditMetadata")
    Menu toEntity(MenuDTO menuDTO);

}
