package com.evela.auth_service.model;


import com.evela.common_service.base.BaseEntity;
import com.evela.common_service.enums.SessionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "sessions")
public class Session extends BaseEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private LocalDateTime loginTime;
    @Column(nullable = true)
    private LocalDateTime logoutTime;
    @Column(nullable = false)
    private String ipAddress;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus status;
    /*@Column(name = "token")
    private String token;*/

}
