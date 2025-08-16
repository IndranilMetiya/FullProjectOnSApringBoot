package com.full.project.entity.mysql;


import com.full.project.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_activities", indexes = {
        @Index(name = "idx_activity_user", columnList = "user_id"),
        @Index(name = "idx_activity_type", columnList = "activity_type"),
        @Index(name = "idx_activity_timestamp", columnList = "activity_timestamp")
})
public class UserActivity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    @Column(name = "activity_description")
    private String activityDescription;

    @Column(name = "activity_timestamp", nullable = false)
    private LocalDateTime activityTimestamp;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "resource_accessed")
    private String resourceAccessed;

    @Column(name = "response_time_ms")
    private Long responseTimeMs;

    @Column(name = "status_code")
    private Integer statusCode;

    }

enum ActivityType {
    LOGIN, LOGOUT, PROFILE_UPDATE, PASSWORD_CHANGE,
    API_CALL, PAGE_VIEW, SEARCH, DOWNLOAD, UPLOAD,
    ERROR, SECURITY_EVENT
}
