package com.evela.auth_service.model;

import com.evela.common_service.base.AuditListener;
import com.evela.common_service.base.AuditMetadata;
import com.evela.common_service.base.BaseEntity;
import com.evela.auth_service.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
//@EntityListeners(AuditingEntityListener.class)
@EntityListeners(AuditingEntityListener.class) // Añadir esta línea
//@EntityListeners(AuditListener.class)
@Table(name = "users")
public class User extends BaseEntity{
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 50)
    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    private String username;

    @Column(nullable = false, length = 60)
    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 6, max = 60, message = "La contraseña debe tener entre 6 y 60 caracteres")
    private String password;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PasswordChangeLog> passwordChangeLogs;

    /*@Column(nullable = false)
    @NotNull(message = "El estado no puede ser nulo")
    private Boolean active = true;*/

    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "roleId"),
                foreignKey = @ForeignKey(name = "user_role_fk"))
    private Set<Role> roles;*/
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Session> sessions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ActivityLog> activityLogs;

    /*@Embedded
    private AuditMetadata auditMetadata;*/

    @Column
    private Boolean locked;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedOn;
/*
    @Override
    public Optional<String> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(createdOn);
    }

    @Override
    public void setCreatedDate(LocalDateTime creationDate) {
        this.createdOn = creationDate;
    }

    @Override
    public Optional<String> getLastModifiedBy() {
        return Optional.ofNullable(updatedBy);
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.updatedBy = lastModifiedBy;
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.ofNullable(updatedOn);
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.updatedOn = lastModifiedDate;
    }

    /*@Override
    public Long getId() {
        return this.userId;
    }*/

    /*@CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;*/
}
