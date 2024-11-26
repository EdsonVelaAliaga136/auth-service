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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(nullable = false, unique = true, length = 100)
    private String roleName;
    @Column(nullable = false)
    private Boolean isActive = true;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_role",
                joinColumns = @JoinColumn(name = "roleId"),
                inverseJoinColumns = @JoinColumn(name = "menuId"),
                foreignKey = @ForeignKey(name = "role_menu_fk"))
    private Set<Menu> menus;

        @CreatedDate
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
    private String updatedBy;
}
