package com.coffee_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "training_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private TechnicalTraining training;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private User farmer;

    @Column(name = "application_time")
    private LocalDateTime applicationTime;


    @PrePersist
    protected void onCreate() {
        applicationTime = LocalDateTime.now();
    }
}
