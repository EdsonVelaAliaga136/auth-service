package com.evela.auth_service.dto;

import com.evela.common_service.dto.AuditMetadataDTO;
import com.evela.common_service.dto.BaseDTO;
import com.evela.common_service.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
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
public class UserDTO extends BaseDTO<Long> {

    //@NotNull(message = "El ID del user no puede ser nulo")
    private Long userId;

    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    @JsonProperty(value = "user_name")
    private String username;

    //@JsonIncludeProperties(value = {"name"})
    private Set<RoleDTO> roles;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 60)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 6, max = 60, message = "La contraseña debe tener entre 6 y 60 caracteres")
    private String password;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @Embedded
    private AuditMetadataDTO auditMetadata;

    private Boolean locked;
    private UserStatus status;

    /*@NotNull(message = "El estado no puede ser nulo")
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean active;*/
}
