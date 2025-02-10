package com.evela.auth_service.dto;

import com.evela.auth_service.model.Role;
import com.evela.common_service.dto.AuditMetadataDTO;
import com.evela.common_service.dto.BaseDTO;
import com.evela.auth_service.enums.SessionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO extends BaseDTO<Long> {

    @NotNull(message = "El ID del menu no puede ser nulo")
    private Long menuId;
    @NotNull(message = "El nombre del menu no puede ser nulo")
    @NotEmpty(message = "El nombre del menu no puede estar vacío")
    @Size(min = 3, max = 200, message = "El nombre del menu debe tener entre 3 y 200 caracteres")
    private String menuName;
    @NotNull(message = "La url no puede ser nulo")
    private String url;
    private String icon;
    private Map<String, Set<String>> permissions;
    @Embedded
    private AuditMetadataDTO auditMetadata;
}
