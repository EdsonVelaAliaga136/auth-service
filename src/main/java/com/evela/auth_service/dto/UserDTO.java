package com.evela.auth_service.dto;

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
public class UserDTO {
        @NotNull
    private Long userId;

    @NotNull
    //@JsonIncludeProperties(value = {"name"})
    private Set<RoleDTO> roles;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    @JsonProperty(value = "user_name")
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 60)
    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isActive;
}
