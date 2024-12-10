package com.evela.auth_service.model;

import com.evela.common_service.base.AuditMetadata;
import com.evela.common_service.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "roles")
public class Role extends BaseEntity{
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_role",
                joinColumns = @JoinColumn(name = "roleId"),
                inverseJoinColumns = @JoinColumn(name = "menuId"),
                foreignKey = @ForeignKey(name = "role_menu_fk"))
    private Set<Menu> menus;
    @ManyToMany
    @JoinTable(name = "role_permission",
                joinColumns = @JoinColumn(name = "roleId"),
                inverseJoinColumns = @JoinColumn(name = "permissionId"),
                foreignKey = @ForeignKey(name = "role_permission_fk"))
    private Set<Permission> permissions;

    @Embedded
    private AuditMetadata auditMetadata;

    /*@Override
    public Long getId() {
        return this.roleId;
    }*/
}
