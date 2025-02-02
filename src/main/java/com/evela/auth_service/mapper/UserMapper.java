package com.evela.auth_service.mapper;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.model.User;
import com.evela.common_service.mapper.IgnoreAuditMapping;
import org.mapstruct.*;


@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    //@Mapping(target = "id", source = "userId")
    //@Mapping(target = "id", source = "userId"),
    /*@Mapping(target = "createdDate", source = "createdDate", qualifiedByName = "fromOptionalLocalDateTime")
    @Mapping(target = "lastModifiedDate", source = "lastModifiedDate", qualifiedByName = "fromOptionalLocalDateTime" )
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "fromOptionalString")
    @Mapping(target = "lastModifiedBy", source = "lastModifiedBy", qualifiedByName = "fromOptionalString")*/
    /*@Mapping(target = "createdDate", source = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", source = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", source = "lastModifiedBy", ignore = true)
    @Mapping(target = "active", source = "active")*/
    //@IgnoreAuditMapping
    /*@Mapping(target = "roles[].createdAt", ignore = true)
    @Mapping(target = "roles[].updatedAt", ignore = true)
    @Mapping(target = "roles[].createdBy", ignore = true)
    @Mapping(target = "roles[].updatedBy", ignore = true)*/
    @Mapping(target = "auditMetadata", source = "auditMetadata")
    UserDTO toDTO(User user);

    //@InheritInverseConfiguration

    //@Mapping(target = "id", source = "userId"),
    /*@Mapping(target = "createdDate", source = "createdDate", qualifiedByName = "toOptionalLocalDateTime")
    @Mapping(target = "lastModifiedDate", source = "lastModifiedDate", qualifiedByName = "toOptionalLocalDateTime" )
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "toOptionalString")
    @Mapping(target = "lastModifiedBy", source = "lastModifiedBy", qualifiedByName = "toOptionalString")*/
    /*@Mapping(target = "createdDate", source = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", source = "lastModifiedDate", ignore = true )
    @Mapping(target = "createdBy", source = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", source = "lastModifiedBy", ignore = true)
    @Mapping(target = "active", source = "active")*/
    //@IgnoreAuditMapping
    /*@Mapping(target = "roles[].createdAt", ignore = true)
    @Mapping(target = "roles[].updatedAt", ignore = true)
    @Mapping(target = "roles[].createdBy", ignore = true)
    @Mapping(target = "roles[].updatedBy", ignore = true)*/
    @Mapping(target = "auditMetadata", source = "auditMetadata")
    User toEntity(UserDTO userDTO);

}
