package com.evela.auth_service.model;

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
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "permissions")
public class Permission extends BaseEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    // for many to many
    //@ManyToMany(mappedBy = "permissions")
    //private Set<Role> roles;
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RolePermission> rolePermissions;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

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
