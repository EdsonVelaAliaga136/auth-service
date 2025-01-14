package com.evela.auth_service.model;

import com.evela.common_service.base.AuditMetadata;
import com.evela.common_service.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "menus")
public class Menu extends BaseEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    @Column(name = "menu_name",nullable = false, unique = true, length = 200)
    private String menuName;

    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "icon")
    private String icon;
    //@ManyToMany(mappedBy = "menus")
    //private Set<Role> roles;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MenuRole> menuRoles;
    /*@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "menu_permissions",
                        joinColumns = @JoinColumn(name = "menuId"))
    @MapKeyColumn(name = "roleName")*/
    /*@Column(name = "permissions")
    private Map<String, Set<String>> permissions;*/
    @Embedded
    private AuditMetadata auditMetadata;
}
