package com.evela.auth_service.dto;

import com.evela.common_service.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO extends BaseDTO<Long> {

    //@NotNull(message = "El ID del rol no puede ser nulo")
    private Long roleId;

    @NotNull(message = "El nombre del rol no puede ser nulo")
    @NotEmpty(message = "El nombre del rol no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre del rol debe tener entre 3 y 100 caracteres")
    private String roleName;

    @NotNull(message = "El estado activo no puede ser nulo")
    private boolean active;

    @NotNull(message = "La descripción no puede ser nula")
    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 100, message = "La descripción debe tener entre 5 y 255 caracteres")
    private String description;
}
