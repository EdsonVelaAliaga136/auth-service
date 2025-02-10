package com.evela.auth_service.model;

import com.evela.common_service.base.AuditListener;
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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "auth_tokens")
@EntityListeners(AuditingEntityListener.class)
public class AuthToken extends BaseEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    @Column(name = "token", nullable = false)
    private String token;
    @Column(name = "expirationDate", nullable = false)
    private LocalDateTime expirationDate;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToOne
    @JoinColumn(name = "session_id" )
    private Session session;

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
