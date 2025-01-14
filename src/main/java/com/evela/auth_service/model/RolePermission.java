package com.evela.auth_service.model;

import com.evela.common_service.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "role_permission")
public class RolePermission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolePermissionId;
    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
