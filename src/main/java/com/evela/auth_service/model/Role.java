package com.evela.auth_service.model;

import com.evela.common_service.audit.Auditable;
import com.evela.common_service.base.AuditListener;
import com.evela.common_service.base.AuditMetadata;
import com.evela.common_service.base.BaseEntity;
import com.evela.common_service.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "roles")
@EntityListeners(AuditListener.class)
public class Role extends BaseEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(nullable = false, unique = true, length = 100)
    private String roleName;
    @Column(nullable = false, length = 100)
    private String description;
    //@Column(nullable = false)
    //private Boolean active = true;
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_role",
                joinColumns = @JoinColumn(name = "roleId"),
                inverseJoinColumns = @JoinColumn(name = "menuId"),
                foreignKey = @ForeignKey(name = "role_menu_fk"))
    private Set<Menu> menus;*/
    // Example for many to many
    /*@ManyToMany
    @JoinTable(name = "role_permission",
                joinColumns = @JoinColumn(name = "roleId"),
                inverseJoinColumns = @JoinColumn(name = "permissionId"),
                foreignKey = @ForeignKey(name = "role_permission_fk"))
    private Set<Permission> permissions;*/
    // For one to many
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RolePermission> rolePermissions;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MenuRole> menuRoles;

    /*@Embedded
    private AuditMetadata auditMetadata;*/

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    /*@Override
    public Long getId() {
        return this.roleId;
    }*/
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
}
