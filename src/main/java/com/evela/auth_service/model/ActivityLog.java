package com.evela.auth_service.model;


import com.evela.common_service.base.BaseEntity;
import com.evela.common_service.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "activity_logs")
public class ActivityLog extends BaseEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityLogId;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private LocalDateTime actionDate;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "ip_address")
    private String ipAddress;
    /*@Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;*/
    /*@OneToOne
    @JoinColumn(name = "session_id")
    private Session session;*/
}
