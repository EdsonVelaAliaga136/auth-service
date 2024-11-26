package com.evela.auth_service.model;

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
import java.util.Map;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "menus")
public class Menu {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    @Column(nullable = false, unique = true, length = 200)
    private String menuName;
    @Column(nullable = false)
    private Boolean isActive = true;
    @Column(nullable = false)
    private String url;
    @Column
    private String icon;
    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "menu_permissions",
                        joinColumns = @JoinColumn(name = "menuId"))
    @MapKeyColumn(name = "roleName")
    @Column(name = "permissions")
    private Map<String, Set<String>> permissions;

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
