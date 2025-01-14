package com.evela.auth_service.model;

import com.evela.common_service.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "menu_role")
public class MenuRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuRoleId;
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
