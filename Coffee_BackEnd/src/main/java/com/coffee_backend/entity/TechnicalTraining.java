package com.coffee_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import com.coffee_backend.enumType.TrainingStatus;
import com.coffee_backend.enumType.TrainingType;

@Entity
@Table(name = "technical_trainings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_time")
    private LocalDateTime startDate;

    @Column(name = "end_time")
    private LocalDateTime endDate;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column(name = "current_participants")
    private Integer currentParticipants;

    @Column(name = "training_type")
    @Enumerated(EnumType.STRING)
    private TrainingType type;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TrainingStatus status;

    @Column(name = "location")
    private String location;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
    }
}