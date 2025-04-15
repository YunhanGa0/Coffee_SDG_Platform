package com.coffee_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.coffee_backend.enumType.CertificationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "certification_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @Column(columnDefinition = "TEXT")
    private String description; // 自述或可持续种植说明

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CertificationStatus status = CertificationStatus.PENDING;

    @Column(name = "admin_feedback")
    private String adminFeedback;

    @Column(name = "submit_time")
    private LocalDateTime submitTime;

    @PrePersist
    protected void onCreate() {
        submitTime = LocalDateTime.now();
    }
}

