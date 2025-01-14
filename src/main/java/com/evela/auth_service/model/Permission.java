package com.evela.auth_service.model;

import com.evela.common_service.base.BaseEntity;
import com.evela.common_service.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RolePermission> rolePermissions;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

}
